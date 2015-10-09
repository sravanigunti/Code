/**
 * GetMD5Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class GetMD5Response  implements java.io.Serializable {
    private java.lang.String getMD5Return;

    public GetMD5Response() {
    }

    public GetMD5Response(
           java.lang.String getMD5Return) {
           this.getMD5Return = getMD5Return;
    }


    /**
     * Gets the getMD5Return value for this GetMD5Response.
     * 
     * @return getMD5Return
     */
    public java.lang.String getGetMD5Return() {
        return getMD5Return;
    }


    /**
     * Sets the getMD5Return value for this GetMD5Response.
     * 
     * @param getMD5Return
     */
    public void setGetMD5Return(java.lang.String getMD5Return) {
        this.getMD5Return = getMD5Return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMD5Response)) return false;
        GetMD5Response other = (GetMD5Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getMD5Return==null && other.getGetMD5Return()==null) || 
             (this.getMD5Return!=null &&
              this.getMD5Return.equals(other.getGetMD5Return())));
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
        if (getGetMD5Return() != null) {
            _hashCode += getGetMD5Return().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetMD5Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", ">getMD5Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getMD5Return");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "getMD5Return"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
