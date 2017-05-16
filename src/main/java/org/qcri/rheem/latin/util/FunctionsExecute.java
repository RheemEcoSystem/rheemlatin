package org.qcri.rheem.latin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bertty on 24-04-17.
 */
public class FunctionsExecute {


    public static boolean contains(String haystack, String[] needles){
        haystack = haystack.toLowerCase();
        for(String needle: needles){
            if( ! haystack.contains(needle.toLowerCase()) ){
                return false;
            }
        }
        return true;
    }

    public static boolean containsOR(String haystack, String[] needles){
        haystack = haystack.toLowerCase();
        for(String needle: needles){
            if( haystack.contains(needle.toLowerCase()) ){
                return true;
            }
        }
        return false;
    }

    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(
            Math.pow(
                x2 - x1,
                2
            )
            +
            Math.pow(
                y2 - y1,
                2
            )
        );
    }

    public static long date(String date){
        return date(date, "YYYY/mm/dd");
    }

    public static long date(String date, String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date _date = null;
        try {
            _date = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return _date.getTime();
    }

    public static int length(String word){
        return word.length();
    }

    public static List<String> cut_each(String haystack, Double _cut_each) {
        int cut_each = _cut_each.intValue();
        List<String> output = new ArrayList<>();
        int start = 0;
        int finish = haystack.length();

        for (start = 0; start < finish-cut_each; start += cut_each) {
            output.add(haystack.substring(start, start+cut_each).trim());
        }

        if(start < finish){
            output.add(haystack.substring(start, finish).trim());
        }
        return output;
    }

    public static String newIdToken(String id, String cuting, Double cut_each){
        List<String> cut = cut_each(cuting, cut_each);
        StringBuilder insert = new StringBuilder();
        StringBuilder values = new StringBuilder();
        insert.append("INSERT INTO booking_shp_code_matrix (booking_id");
        values.append(" VALUES( ");
        values.append(id);
        for(int i = 0; i < cut.size(); i++){
            insert.append(", "+cut.get(i));
            values.append(", 1");
        }
        insert.append(")");
        values.append(");");
        insert.append(values.toString());
        return insert.toString();
    }
}

