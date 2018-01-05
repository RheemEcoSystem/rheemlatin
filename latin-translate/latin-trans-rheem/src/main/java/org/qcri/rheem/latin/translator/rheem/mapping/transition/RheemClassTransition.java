package org.qcri.rheem.latin.translator.rheem.mapping.transition;

import org.qcri.rheem.latin.translator.rheem.mapping.MappingFinal;
import org.qcri.rheem.latin.translator.rheem.mapping.ParameterType;

import java.util.List;

public class RheemClassTransition {

    private String name_latin;
    private String name_rheem;
    private List<String> parameters;
    private String package_name;

    public String getName_latin() {
        return name_latin;
    }

    public void setName_latin(String name_latin) {
        this.name_latin = name_latin;
    }

    public String getName_rheem() {
        return name_rheem;
    }

    public void setName_rheem(String name_rheem) {
        this.name_rheem = name_rheem;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public ParameterType[] parameterConvert(){
        ParameterType[] tmp = new ParameterType[this.parameters.size()];
        int i = 0;
        for (String param : this.parameters) {
            tmp[i] = ParameterType.find(param);
            i++;
        }
        return tmp;
    }
}
