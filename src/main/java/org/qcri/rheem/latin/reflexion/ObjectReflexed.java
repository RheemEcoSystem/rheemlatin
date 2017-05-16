package org.qcri.rheem.latin.reflexion;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by bertty on 06-04-17.
 */
public class ObjectReflexed implements ObjectConf{
    private String        nameClass    = null;
    private String        namePackage  = null;
    private String        nameExtend   = null;

    private Method[]      methods      = null;

    private Constructor[] constructors = null;

    private Class         classObject  = null;

    private Reflections   reflections  = null;

    @Override
    public String getName() {
        return null;
    }






}
