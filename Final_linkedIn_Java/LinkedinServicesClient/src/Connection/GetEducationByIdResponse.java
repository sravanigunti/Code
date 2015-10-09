/**
 * GetEducationByIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class GetEducationByIdResponse  implements java.io.Serializable {
    private Connection.Education getEducationByIdReturn;

    public GetEducationByIdResponse() {
    }

    public GetEducationByIdResponse(
           Connection.Education getEducationByIdReturn) {
           this.getEducationByIdReturn = getEducationByIdReturn;
    }


    /**
     * Gets the getEducationByIdReturn value for this GetEducationByIdResponse.
     * 
     * @return getEducationByIdReturn
     */
    public Connection.Education getGetEducationByIdReturn() {
        return getEducationByIdReturn;
    }


    /**
     * Sets the getEducationByIdReturn value for this GetEducationByIdResponse.
     * 
     * @param getEducationByIdReturn
     */
    public void setGetEducationByIdReturn(Connection.Education getEducationByIdReturn) {
        this.getEducationByIdReturn = getEducationByIdReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEducationByIdResponse)) return false;
        GetEducationByIdResponse other = (GetEducationByIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getEducationByIdReturn==null && other.getGetEducationByIdReturn()==null) || 
             (this.getEducationByIdReturn!=null &&
              this.getEducationByIdReturn.equals(other.getGetEducationByIdReturn())));
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
        if (getGetEducationByIdReturn() != null) {
            _hashCode += getGetEducationByIdReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEducationByIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", ">getEducationByIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getEducationByIdReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "getEducationByIdReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Connection", "Education"));
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
