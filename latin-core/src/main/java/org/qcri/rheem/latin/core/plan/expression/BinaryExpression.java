package org.qcri.rheem.latin.core.plan.expression;

import org.qcri.rheem.latin.core.plan.LatinElement;

public class BinaryExpression extends LatinExpression{

    private LatinExpression[] branch;
    private int index_branch;

    public BinaryExpression(String name) {
        super(name);
        this.branch = new LatinExpression[2];
    }

    @Override
    protected void selfCopy(LatinElement element) {

    }

    public BinaryExpression(String name, LatinExpression left, LatinExpression right){
        super(name);
        this.branch = new LatinExpression[2];
        this.branch[0] = left;
        this.branch[1] = right;
    }

    public LatinExpression getLeft_branch() {
        return this.branch[0];
    }

    public void setLeft_branch(LatinExpression left_branch) {
        this.branch[0]= left_branch;
    }

    public LatinExpression getRight_branch() {
        return this.branch[1];
    }

    public void setRight_branch(LatinExpression right_branch) {
        this.branch[1] = right_branch;
    }

    public void insertBranch(LatinExpression branch) throws Exception {
        if(this.branch[0] == null){
            setLeft_branch(branch);
            return;
        }
        if(this.branch[1] == null){
            setRight_branch(branch);
            return;
        }
        //TODO: create a good message
        throw new Exception("Falta crear la exception");
    }


    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Operator: "+this.name+"\n");
        output.append("     left of("+this.name+")-->"+this.getLeft_branch().toString());
        output.append("    right of("+this.name+")-->"+this.getRight_branch().toString());
        return output.toString();
    }

    @Override
    public boolean hasChildren() {
        return (this.branch[0] != null || this.branch[1] != null);
    }

    @Override
    public boolean hasMoreChildren() {
        return this.index_branch < this.branch.length;
    }

    @Override
    public LatinExpression nextChildren() {
        return this.branch[this.index_branch++];
    }

    @Override
    public void goFirstChildren() {
        this.index_branch = 0;
    }

    @Override
    public int countChildren() {
        return 2;
    }
}
