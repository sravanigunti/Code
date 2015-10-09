/**
 * SignInResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class SignInResponse  implements java.io.Serializable {
    private java.lang.String signInReturn;

    public SignInResponse() {
    }

    public SignInResponse(
           java.lang.String signInReturn) {
           this.signInReturn = signInReturn;
    }


    /**
     * Gets the signInReturn value for this SignInResponse.
     * 
     * @return signInReturn
     */
    public java.lang.String getSignInReturn() {
        return signInReturn;
    }


    /**
     * Sets the signInReturn value for this SignInResponse.
     * 
     * @param signInReturn
     */
    public void setSignInReturn(java.lang.String signInReturn) {
        this.signInReturn = signInReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SignInResponse)) return false;
        SignInResponse other = (SignInResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.signInReturn==null && other.getSignInReturn()==null) || 
             (this.signInReturn!=null &&
              this.signInReturn.equals(other.getSignInReturn())));
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
        if (getSignInReturn() != null) {
            _hashCode += getSignInReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SignInResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", ">signInResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("signInReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "signInReturn"));
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
