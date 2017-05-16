package org.qcri.rheem.basic.operators;

import org.qcri.rheem.basic.data.RecordDinamic;
import org.qcri.rheem.core.plan.rheemplan.UnarySource;
import org.qcri.rheem.core.types.DataSetType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bertty on 16-04-17.
 */
public class JSONSource extends UnarySource<RecordDinamic> {
    private final String       inputUrl;
    private final String       enconding;
    private final List<String> words_tokens = new ArrayList<>();

    public JSONSource(String inputUrl) {
        this(inputUrl, "UTF-8");
    }

    public JSONSource(String inputUrl, String encoding) {
        super(DataSetType.createDefault(RecordDinamic.class));
        this.inputUrl = inputUrl;
        this.enconding = encoding;
    }

    public JSONSource(String inputUrl, String[] words) {
        this(inputUrl, "UTF-8");
        this.words_tokens.addAll(Arrays.asList(words));
    }


    public JSONSource(JSONSource that) {
        super(that);
        this.words_tokens.addAll(Arrays.asList(that.getWords_tokens()));
        this.inputUrl = that.getInputUrl();
        this.enconding = that.getEnconding();
    }


    public TextFileSource getFile() {
        return new TextFileSource(inputUrl, enconding);
    }

    public String[] getWords_tokens() {
        return words_tokens.toArray(new String[0]);
    }

    public String getInputUrl() {
        return inputUrl;
    }

    public String getEnconding() {
        return enconding;
    }
}
