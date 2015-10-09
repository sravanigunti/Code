/**
 * GetExperienceByIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class GetExperienceByIdResponse  implements java.io.Serializable {
    private Connection.Experience getExperienceByIdReturn;

    public GetExperienceByIdResponse() {
    }

    public GetExperienceByIdResponse(
           Connection.Experience getExperienceByIdReturn) {
           this.getExperienceByIdReturn = getExperienceByIdReturn;
    }


    /**
     * Gets the getExperienceByIdReturn value for this GetExperienceByIdResponse.
     * 
     * @return getExperienceByIdReturn
     */
    public Connection.Experience getGetExperienceByIdReturn() {
        return getExperienceByIdReturn;
    }


    /**
     * Sets the getExperienceByIdReturn value for this GetExperienceByIdResponse.
     * 
     * @param getExperienceByIdReturn
     */
    public void setGetExperienceByIdReturn(Connection.Experience getExperienceByIdReturn) {
        this.getExperienceByIdReturn = getExperienceByIdReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetExperienceByIdResponse)) return false;
        GetExperienceByIdResponse other = (GetExperienceByIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getExperienceByIdReturn==null && other.getGetExperienceByIdReturn()==null) || 
             (this.getExperienceByIdReturn!=null &&
              this.getExperienceByIdReturn.equals(other.getGetExperienceByIdReturn())));
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
        if (getGetExperienceByIdReturn() != null) {
            _hashCode += getGetExperienceByIdReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetExperienceByIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", ">getExperienceByIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getExperienceByIdReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "getExperienceByIdReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Connection", "Experience"));
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
