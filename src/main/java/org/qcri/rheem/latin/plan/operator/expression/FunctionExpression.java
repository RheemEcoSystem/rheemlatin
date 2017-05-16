package org.qcri.rheem.latin.plan.operator.expression;

import org.qcri.rheem.latin.plan.operator.LatinExpression;

/**
 * Created by bertty on 06-04-17.
 */
public class FunctionExpression extends LatinExpression {

    private int               nparams = 0;

    private int               index_branch = 0;

    private LatinExpression[] params  = null;


    public FunctionExpression(String name) {
        super(name);
    }

    public FunctionExpression(String name, int nparams){
        super(name);
        this.nparams = nparams;
        this.params  = new LatinExpression[this.nparams];
    }

    public FunctionExpression(String name, LatinExpression ... params){
        super(name);
        this.params  = params;
        this.nparams = params.length;
    }

    public void setParams(LatinExpression ... params){
        this.params  = params;
        this.nparams = params.length;
    }

    public void setParam(int index, LatinExpression param) throws IndexOutOfBoundsException{
        if(index < 0 || index >= nparams){
            throw new IndexOutOfBoundsException("index is bad for FunctionExpression");
        }
        this.params[index] = param;
    }

    public LatinExpression[] getParams(){
        return this.params;
    }

    public LatinExpression getParam(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= nparams){
            throw new IndexOutOfBoundsException("index is bad for FunctionExpression");
        }
        return this.params[index];
    }

    public int getNparams() {
        return nparams;
    }

    public boolean setNparams(int nparams) {
        if(nparams <= this.nparams){
            return false;
        }

        LatinExpression[] _params = new LatinExpression[nparams];
        for(int i = 0; i < this.params.length; i++){
            _params[i] = this.params[i];
        }
        this.params = _params;
        this.nparams = nparams;
        return true;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(this.name);
        builder.append(" ( ");
        for(int i = 0; i < this.nparams; i++) {
            builder.append(this.params[i]);
            builder.append(", ");
        }
        builder.append(" ) ");

        return builder.toString();
    }

    @Override
    public boolean hasChildren() {
        return this.nparams > 0;
    }

    @Override
    public boolean hasMoreChildren() {
        return this.index_branch < this.nparams;
    }

    @Override
    public LatinExpression nextChildren() {
        return this.params[this.index_branch++];
    }

    @Override
    public void goFirstChildren() {
        this.index_branch = 0;
    }

    @Override
    public int countChildren() {
        return this.params.length;
    }
}
