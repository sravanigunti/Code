/**
 * Skills.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connection;

public class Skills  implements java.io.Serializable {
    private int id;

    private java.lang.String skillset;

    private int user_id;

    public Skills() {
    }

    public Skills(
           int id,
           java.lang.String skillset,
           int user_id) {
           this.id = id;
           this.skillset = skillset;
           this.user_id = user_id;
    }


    /**
     * Gets the id value for this Skills.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Skills.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the skillset value for this Skills.
     * 
     * @return skillset
     */
    public java.lang.String getSkillset() {
        return skillset;
    }


    /**
     * Sets the skillset value for this Skills.
     * 
     * @param skillset
     */
    public void setSkillset(java.lang.String skillset) {
        this.skillset = skillset;
    }


    /**
     * Gets the user_id value for this Skills.
     * 
     * @return user_id
     */
    public int getUser_id() {
        return user_id;
    }


    /**
     * Sets the user_id value for this Skills.
     * 
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Skills)) return false;
        Skills other = (Skills) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.skillset==null && other.getSkillset()==null) || 
             (this.skillset!=null &&
              this.skillset.equals(other.getSkillset()))) &&
            this.user_id == other.getUser_id();
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
        _hashCode += getId();
        if (getSkillset() != null) {
            _hashCode += getSkillset().hashCode();
        }
        _hashCode += getUser_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Skills.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Connection", "Skills"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("skillset");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "skillset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Connection", "user_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
