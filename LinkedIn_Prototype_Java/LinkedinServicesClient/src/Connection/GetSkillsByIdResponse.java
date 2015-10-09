/**
 * GetSkillsByIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class GetSkillsByIdResponse  implements java.io.Serializable {
    private Connection.Skills getSkillsByIdReturn;

    public GetSkillsByIdResponse() {
    }

    public GetSkillsByIdResponse(
           Connection.Skills getSkillsByIdReturn) {
           this.getSkillsByIdReturn = getSkillsByIdReturn;
    }


    /**
     * Gets the getSkillsByIdReturn value for this GetSkillsByIdResponse.
     * 
     * @return getSkillsByIdReturn
     */
    public Connection.Skills getGetSkillsByIdReturn() {
        return getSkillsByIdReturn;
    }


    /**
     * Sets the getSkillsByIdReturn value for this GetSkillsByIdResponse.
     * 
     * @param getSkillsByIdReturn
     */
    public void setGetSkillsByIdReturn(Connection.Skills getSkillsByIdReturn) {
        this.getSkillsByIdReturn = getSkillsByIdReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSkillsByIdResponse)) return false;
        GetSkillsByIdResponse other = (GetSkillsByIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getSkillsByIdReturn==null && other.getGetSkillsByIdReturn()==null) || 
             (this.getSkillsByIdReturn!=null &&
              this.getSkillsByIdReturn.equals(other.getGetSkillsByIdReturn())));
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
        if (getGetSkillsByIdReturn() != null) {
            _hashCode += getGetSkillsByIdReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetSkillsByIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", ">getSkillsByIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSkillsByIdReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "getSkillsByIdReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Connection", "Skills"));
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
