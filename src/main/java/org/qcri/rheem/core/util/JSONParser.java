package org.qcri.rheem.core.util;

import org.qcri.rheem.basic.data.Record;
import org.qcri.rheem.basic.data.RecordDinamic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by bertty on 16-04-17.
 */
public class JSONParser implements Serializable {

    public static RecordDinamic execute(String json, String... tokens){
        RecordDinamic record = new RecordDinamic(tokens);

        char[] vector = json.toCharArray();

        Stack<Character> parenthesis = new Stack<>();
        List<String> alltokens;

        boolean   allJson        = false;
        int       tokenToProcess;
        boolean[] findeds;
        if(tokens != null && tokens.length > 0) {
            findeds        = new boolean[tokens.length];
            tokenToProcess = tokens.length;
            alltokens      = Arrays.asList(tokens);

        }else{
            allJson        = true;
            tokenToProcess = -1;
            alltokens      = null;
            findeds        = null;
        }

        int     size         = json.length();
        int     start        = -1;
        int     length       = -1;
        int     objectStart  = -1;
        int     objectlength = -1;
        int     arrayStart   = -1;
        int     arrayLength  = -1;
        int     numberStart  = -1;
        int     numberLength = -1;

        boolean inString     = false;
        boolean inPairkey    = true;
        boolean nextKey      = false;
        boolean inObject     = false;
        boolean inArray      = false;
        boolean inNumber     = false;
        boolean underOfKey   = false;
        String  key          = null;
        Object  value        = null;

        for(int i = 0; i < size; i++){
            if(value != null){
                record.setValue(key, value);
                value = null;
                if (!allJson) {
                    if (--tokenToProcess <= 0) {
                        record.setUse(i, size+1);
                        return record;
                    }
                }
            }
            if(nextKey){
                switch (vector[i]){
                    case '{':
                    case '[':
                        parenthesis.push(vector[i]);
                        break;
                    case '}':
                    case ']':
                        if(!parenthesis.empty())
                            parenthesis.pop();
                        break;
                    case ',':
                        if(parenthesis.empty()){
                            nextKey = false;
                        }
                        break;
                    case '"':
                        if(!parenthesis.empty()){
                            parenthesis.clear();
                            inString = true;
                            start = i + 1;
                            length = 0;
                            nextKey  = false;
                        }
                        break;
                }
                continue;
            }
            if(inObject){
                if(vector[i] == '}'){
                    parenthesis.pop();
                    if( parenthesis.empty() ) {
                        value = execute(String.valueOf(vector, objectStart, objectlength));
                        underOfKey = false;
                        inObject = false;
                    }
                }
                if(vector[i] == '{'){
                    parenthesis.push(vector[i]);
                }
                objectlength++;
                continue;
            }
            if(inArray){
                if(vector[i] == ']'){
                    parenthesis.pop();
                    if( parenthesis.empty() ) {
                        value = createArray(String.valueOf(vector, arrayStart, arrayLength));
                        underOfKey = false;
                        inArray = false;
                    }
                }
                if(vector[i] == '['){
                    parenthesis.push(vector[i]);
                }
                arrayLength++;
                continue;
            }
            if(inString) {
                if (vector[i] == '"' && vector[i - 1] != '\\') {

                    inString = false;
                    if (inPairkey) {
                        key = String.valueOf(vector, start, length);
                        if (!allJson) {
                            int index = alltokens.indexOf(key);
                            if (index == -1) {
                                nextKey = true;
                                continue;
                            } else {
                                if (findeds[index]) {
                                   /* try {
                                        throw new Exception("problema con la palabra");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        System.exit(-104);
                                    }*/
                                }
                                findeds[index] = true;
                                underOfKey = true;
                            }
                        } else {
                            underOfKey = true;
                        }
                        continue;
                    } else {
                        value = String.valueOf(vector, start, length);
                    }
                }
                length++;
                continue;
            }
            if(inNumber){
                switch (vector[i]){
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case 'e':
                    case 'E':
                    case '.':
                    case '+':
                    case '-':
                        numberLength++;
                        break;
                    default:
                        value = String.valueOf(vector, numberStart, numberLength);
                        inNumber = false;
                        break;
                }
                continue;
            }
            if( ! inPairkey ){
                String word = null;
                switch (vector[i]){
                    case ' ':
                    case '\t':
                    case '\n':
                        continue;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '-':
                        numberStart = i;
                        numberLength = 1;
                        inNumber = true;
                        continue;
                    case 'f':
                    case 'F':
                        word = "false";
                        break;
                    case 't':
                    case 'T':
                        word = "true";
                        break;
                    case 'n':
                    case 'N':
                        word = "null";
                        break;
                }
                if(word != null) {
                    String wordInJson = String.copyValueOf(vector, i , word.length());
                    if (!word.equalsIgnoreCase(wordInJson)) {
                        /*try {
                            throw new Exception("Palabra no es reservado");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.exit(-106);
                        }*/
                    }
                    i += word.length() - 1;
                    value = wordInJson;
                    continue;
                }
            }
            if( ! inString ) {
                switch (vector[i]) {
                    case '{':
                        if( underOfKey ) {
                            inObject     = true;
                            objectStart  = i;
                            objectlength = 1;
                            parenthesis.push(vector[i]);
                        }
                        break;
                    case '[':
                        if( underOfKey ){
                            inArray     = true;
                            arrayStart  = i + 1;
                            arrayLength = 0;
                            parenthesis.push(vector[i]);
                        }
                        break;
                    case '"':
                        inString = true;
                        start = i + 1;
                        length = 0;

                        break;
                    case ':':
                        inPairkey = false;
                        break;
                    case ',':
                        inPairkey = true;
                        break;

                    case ' ':
                    case '\n':
                    case '\t':
                        continue;

                    default:
                        //System.out.println("parece que falta algo");
                        break;
                }
                continue;
            }

        }
        record.setUse(size+1, size+1);
        return record;
    }


    private static Record createArray(String json){
        ArrayList<Object> values = new ArrayList<>();
        Stack<Character> parenthesis = new Stack<>();


        int sizeJson     = json.length();
        char[] vector    = json.toCharArray();
        int valueStart   = -1;
        int valueLength  = -1;
        boolean isObject = false;
        boolean isArray  = false;
        boolean isString = false;
        boolean isConst  = false;
        boolean isNumber = false;



        for(int i = 0; i < sizeJson; i++){
            if(isObject){
                if(vector[i] == '}'){
                    parenthesis.pop();
                    if( parenthesis.empty() ) {
                        values.add( execute(String.copyValueOf(vector, valueStart, valueLength+1)) );
                        isObject = false;
                        continue;
                    }
                }
                if(vector[i] == '{'){
                    parenthesis.push(vector[i]);
                }
                valueLength++;
                continue;
            }
            if(isArray){
                if(vector[i] == ']'){
                    parenthesis.pop();
                    if( parenthesis.empty() ) {
                        values.add( createArray( String.copyValueOf(vector, valueStart, valueLength) ) );
                        isArray = false;
                        continue;
                    }
                }
                if(vector[i] == '['){
                    parenthesis.push(vector[i]);
                }
                valueLength++;
                continue;
            }
            if(isString){
                if(vector[i] == '"'){
                    values.add( String.copyValueOf(vector, valueStart, valueLength) );
                    isString = false;
                    continue;
                }
                valueLength++;
                continue;
            }
            if(isNumber){
                switch (vector[i]){
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case 'e':
                    case 'E':
                    case '.':
                    case '+':
                    case '-':
                        valueLength++;
                        continue;
                    default:
                        values.add( String.copyValueOf(vector, valueStart, valueLength) );
                        isNumber = false;
                        break;
                }
            }
            if(isConst){
                String word = "";
                switch (vector[i-1]){
                    case 'f':
                    case 'F':
                        word = "false";
                        break;
                    case 't':
                    case 'T':
                        word = "true";
                        break;
                    case 'n':
                    case 'N':
                        word = "null";
                        break;
                }
                String wordInJson = String.copyValueOf(vector, i-1, word.length());
                if( ! word.equalsIgnoreCase(wordInJson)){
                    try {
                        throw new Exception("Palabra no es reservado");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(-106);
                    }
                }
                i += word.length() - 1;
                isConst = false;
            }
            switch (vector[i]){
                case ' ':
                case '\t':
                case '\n':
                    continue;
                case '{':
                    isObject = true;
                    valueStart = i;
                    valueLength = 1;
                    parenthesis.push(vector[i]);
                    break;
                case '[':
                    isArray = true;
                    valueStart = i;
                    valueLength = 1;
                    parenthesis.push(vector[i]);
                    break;
                case '"':
                    isString = true;
                    valueStart = i+1;
                    valueLength = 0;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '-':
                    valueStart = i;
                    valueLength = 1;
                    isNumber = true;
                    break;
                case 'f':
                case 'F':
                case 't':
                case 'T':
                case 'n':
                case 'N':
                    isConst = true;
                    break;
            }
        }

        return new Record(values.toArray());
    }


}
