package org.qcri.rheem.latin.util;

import org.joda.time.DateTime;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 * A class of static final values used to encode data type and a number of
 * static helper functions for manipulating data objects.  The data type
 * values could be
 * done as an enumeration, but it is done as byte codes instead to save
 * creating objects.
 */
public class DataType {
    // IMPORTANT! This list can be used to record values of data on disk,
    // so do not change the values.  You may strand user data.
    // IMPORTANT! Order matters here, as compare() below uses the order to
    // order unlike datatypes.  Don't change this ordering.
    // Spaced unevenly to leave room for new entries without changing
    // values or creating order issues.
    public static final byte UNKNOWN    =   0;
    public static final byte NULL       =   1;
    public static final byte BOOLEAN    =   5;
    public static final byte BYTE       =   6; // internal use only
    public static final byte INTEGER    =  10;
    public static final byte LONG       =  15;
    public static final byte FLOAT      =  20;
    public static final byte DOUBLE     =  25;
    public static final byte DATETIME   =  30;
    public static final byte BYTEARRAY  =  50;
    public static final byte CHARARRAY  =  55;
    public static final byte BIGINTEGER =  65;
    public static final byte BIGDECIMAL =  70;
    /**
     * Internal use only.
     */
    public static final byte BIGCHARARRAY =  60; //internal use only; for storing/loading chararray bigger than 64K characters in BinStorage
    public static final byte MAP          = 100;
    public static final byte TUPLE        = 110;
    public static final byte BAG          = 120;

    /**
     * Internal use only; used to store WriteableComparable objects
     * for creating ordered index in MergeJoin. Expecting a object that
     * implements Writable interface and has default constructor
     */
    public static final byte GENERIC_WRITABLECOMPARABLE = 123;

    /**
     * Internal use only.
     */
    public static final byte INTERNALMAP = 127; // internal use only; for maps that are object->object.  Used by FindQuantiles.
    public static final byte ERROR       =  -1;


    /**
     * Determine the datatype of an object.
     * @param o Object to test.
     * @return byte code of the type, or ERROR if we don't know.
     */
    public static byte findType(Object o) {
        if (o == null) {
            return NULL;
        }

        // Try to put the most common first
        if (o instanceof String) {
            return CHARARRAY;
        } else if (o instanceof Integer) {
            return INTEGER;
        } else if (o instanceof Long) {
            return LONG;
        } else if (o instanceof InternalMap) {
            return INTERNALMAP;
        } else if (o instanceof Map) {
            return MAP;
        } else if (o instanceof Float) {
            return FLOAT;
        } else if (o instanceof Double) {
            return DOUBLE;
        } else if (o instanceof Boolean) {
            return BOOLEAN;
        } else if (o instanceof DateTime) {
            return DATETIME;
        } else if (o instanceof Byte) {
            return BYTE;
        } else if (o instanceof BigInteger) {
            return BIGINTEGER;
        } else if (o instanceof BigDecimal) {
            return BIGDECIMAL;
        } else {return ERROR;}
    }

    /**
     * Given a Type object determine the data type it represents.  This isn't
     * cheap, as it uses reflection, so use sparingly.
     * @param t Type to examine
     * @return byte code of the type, or ERROR if we don't know.
     */
    public static byte findType(Type t) {
        if (t == null) {
            return NULL;
        }

        // Try to put the most common first
        if (t == String.class) {
            return CHARARRAY;
        } else if (t == Integer.class) {
            return INTEGER;
        } else if (t == Long.class) {
            return LONG;
        } else if (t == Float.class) {
            return FLOAT;
        } else if (t == Double.class) {
            return DOUBLE;
        } else if (t == Boolean.class) {
            return BOOLEAN;
        } else if (t == Byte.class) {
            return BYTE;
        } else if (t == BigInteger.class) {
            return BIGINTEGER;
        } else if (t == BigDecimal.class) {
            return BIGDECIMAL;
        } else if (t == DateTime.class) {
            return DATETIME;
        } else if (t == InternalMap.class) {
            return INTERNALMAP;
        } else {
            // Might be a tuple or a bag, need to check the interfaces it
            // implements
            if (t instanceof Class) {
                return extractTypeFromClass(t);
            }else if (t instanceof ParameterizedType){
                ParameterizedType impl=(ParameterizedType)t;
                Class c=(Class)impl.getRawType();
                return extractTypeFromClass(c);
            }
            return ERROR;
        }
    }

    private static byte extractTypeFromClass(Type t) {
        Class c = (Class)t;
        Class[] ioeInterfaces = c.getInterfaces();
        Class[] interfaces = null;
        if(c.isInterface()){
            interfaces = new Class[ioeInterfaces.length+1];
            interfaces[0] = c;
            for (int i = 1; i < interfaces.length; i++) {
                interfaces[i] = ioeInterfaces[i-1];
            }
        }  else {
            interfaces = ioeInterfaces;
        }
        boolean matchedWritableComparable = false;
        for (int i = 0; i < interfaces.length; i++) {
            if (interfaces[i].getName().equals("java.util.Map")) {
                return MAP;
            }
        }

        return ERROR;
    }

    /**
     * Get the type name.
     * @param o Object to test.
     * @return type name, as a String.
     */
    public static String findTypeName(Object o) {
        return findTypeName(findType(o));
    }

    /**
     * Get the type name from the type byte code
     * @param dt Type byte code
     * @return type name, as a String.
     */
    public static String findTypeName(byte dt) {
        switch (dt) {
            case NULL:      return "NULL";
            case BOOLEAN:   return "boolean";
            case BYTE:      return "byte";
            case INTEGER:   return "int";
            case BIGINTEGER:                    return "biginteger";
            case BIGDECIMAL:                    return "bigdecimal";
            case LONG:      return "long";
            case FLOAT:     return "float";
            case DOUBLE:    return "double";
            case DATETIME:  return "datetime";
            case BYTEARRAY: return "bytearray";
            case BIGCHARARRAY: return "bigchararray";
            case CHARARRAY: return "chararray";
            case MAP:       return "map";
            case INTERNALMAP: return "internalmap";
            default: return "Unknown";
        }
    }

    public static Class<?> findTypeClass(byte dt) {
        switch (dt) {
            case NULL:      return Void.TYPE;
            case BOOLEAN:   return Boolean.TYPE;
            case BYTE:      return Byte.TYPE;
            case INTEGER:   return Integer.TYPE;
            case BIGINTEGER:                    return BigInteger.class;
            case BIGDECIMAL:                    return BigDecimal.class;
            case LONG:      return Long.TYPE;
            case FLOAT:     return Float.TYPE;
            case DOUBLE:    return Double.TYPE;
            case DATETIME:  return DateTime.class;
            case BIGCHARARRAY: return String.class;
            case CHARARRAY: return String.class;
            case MAP:       return Map.class;
            case INTERNALMAP: return InternalMap.class;
            default: throw new RuntimeException("Invalid type has no corresponding class: " + dt);
        }
    }


    /**
     * Determine whether the this object can have a schema.
     * @param o Object to determine if it has a schema
     * @return true if the type can have a valid schema (i.e., bag or tuple)
     */
    public static boolean isSchemaType(Object o) {
        return isSchemaType(findType(o));
    }

    /**
     * Determine whether the this data type can have a schema.
     * @param dataType dataType to determine if it has a schema
     * @return true if the type can have a valid schema (i.e., bag or tuple)
     */
    public static boolean isSchemaType(byte dataType) {
        return false;
    }

    /**
     * Determine if this type is a numeric type.
     * @param t type (as byte value) to test
     * @return true if this is a numeric type, false otherwise
     */
    public static boolean isNumberType(byte t) {
        switch (t) {
            case INTEGER:       return true ;
            case LONG:          return true ;
            case FLOAT:         return true ;
            case DOUBLE:        return true ;
            case BIGINTEGER:    return true ;
            case BIGDECIMAL:    return true ;
            default:            return false ;
        }
    }

    /**
     * Determine whether the this data type is complex.
     * @param dataType Data type code to test.
     * @return true if dataType is bag, tuple, or map.
     */
    public static boolean isComplex(byte dataType) {
        return ((dataType == BAG) || (dataType == TUPLE) ||
                (dataType == MAP) || (dataType == INTERNALMAP));
    }

    /**
     * Test if one type can cast to the other.
     * @param castType data type of the cast type
     * @param inputType data type of the input
     * @return true or false
     */
    public static boolean castable(byte castType, byte inputType) {
        // Only legal types can be cast to
        if ( (!DataType.isUsableType(castType)) ||
                (!DataType.isUsableType(inputType)) ) {
            return false;
        }

        // Same type is castable
        if (castType==inputType) {
            return true;
        }

        // Numerical type is castable
        if ( (DataType.isNumberType(castType)) &&
                (DataType.isNumberType(inputType)) ) {
            return true;
        }

        // databyte can cast to anything
        if (inputType == DataType.BYTEARRAY) {
            return true;
        }

        // Cast numerical type to string, or vice versa is valid
        if (DataType.isNumberType(inputType)&&castType==DataType.CHARARRAY ||
                DataType.isNumberType(castType)&&inputType==DataType.CHARARRAY)
            return true;

        // else return false
        return false;
    }

    /**
     * Determine if this is a type that can work can be done on.
     * @param t type (as a byte value) to test
     * @return false if the type is unknown, null, or error; true otherwise.
     */
    public static boolean isUsableType(byte t) {
        switch (t) {
            case UNKNOWN:    return false ;
            case NULL:       return false ;
            case ERROR:      return false ;
            default :return true ;
        }
    }



    /**
     * Merge types if possible.  Merging types means finding a type that one
     * or both types can be upcast to.
     * @param type1
     * @param type2
     * @return the merged type, or DataType.ERROR if not successful
     */
    public static byte mergeType(byte type1, byte type2) {
        // Only legal types can be merged
        if ( (!DataType.isUsableType(type1)) ||
                (!DataType.isUsableType(type2)) ) {
            return DataType.ERROR ;
        }

        // Same type is OK
        if (type1==type2) {
            return type1 ;
        }

        // Both are number so we return the bigger type
        if ( (DataType.isNumberType(type1)) &&
                (DataType.isNumberType(type2)) ) {
            return type1>type2 ? type1:type2 ;
        }

        // One is bytearray and the other is (number or chararray)
        if (type1 == DataType.BYTEARRAY) {
            return type2 ;
        }

        if (type2 == DataType.BYTEARRAY) {
            return type1 ;
        }

        // else return just ERROR
        return DataType.ERROR ;
    }

    /**
     * Determine whether the this data type is atomic.
     * @param dataType Data type code to test.
     * @return true if dataType is bytearray, bigchararray, chararray, integer, long,
     * float, or boolean.
     */
    public static boolean isAtomic(byte dataType) {
        return ((dataType == BYTEARRAY) ||
                (dataType == CHARARRAY) ||
                (dataType == BIGCHARARRAY) ||
                (dataType == INTEGER) ||
                (dataType == BIGINTEGER) ||
                (dataType == BIGDECIMAL) ||
                (dataType == LONG) ||
                (dataType == FLOAT) ||
                (dataType == DOUBLE) ||
                (dataType == BOOLEAN) ||
                (dataType == BYTE) ||
                (dataType == DATETIME) ||
                (dataType == GENERIC_WRITABLECOMPARABLE));
    }
}
