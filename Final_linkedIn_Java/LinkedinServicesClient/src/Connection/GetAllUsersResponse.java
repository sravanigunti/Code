/**
 * GetAllUsersResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class GetAllUsersResponse  implements java.io.Serializable {
    private java.lang.Object[] getAllUsersReturn;

    public GetAllUsersResponse() {
    }

    public GetAllUsersResponse(
           java.lang.Object[] getAllUsersReturn) {
           this.getAllUsersReturn = getAllUsersReturn;
    }


    /**
     * Gets the getAllUsersReturn value for this GetAllUsersResponse.
     * 
     * @return getAllUsersReturn
     */
    public java.lang.Object[] getGetAllUsersReturn() {
        return getAllUsersReturn;
    }


    /**
     * Sets the getAllUsersReturn value for this GetAllUsersResponse.
     * 
     * @param getAllUsersReturn
     */
    public void setGetAllUsersReturn(java.lang.Object[] getAllUsersReturn) {
        this.getAllUsersReturn = getAllUsersReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAllUsersResponse)) return false;
        GetAllUsersResponse other = (GetAllUsersResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAllUsersReturn==null && other.getGetAllUsersReturn()==null) || 
             (this.getAllUsersReturn!=null &&
              java.util.Arrays.equals(this.getAllUsersReturn, other.getGetAllUsersReturn())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGetAllUsersReturn() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGetAllUsersReturn());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGetAllUsersReturn(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAllUsersResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", ">getAllUsersResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAllUsersReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "getAllUsersReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://Connection", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
