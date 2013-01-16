/**
 * EmpleadoServicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.operix.www;

public class EmpleadoServicio  implements java.io.Serializable {
    private java.lang.String cuil;

    private int remNetImpAcum;

    private int totPagAnt;

    public EmpleadoServicio() {
    }

    public EmpleadoServicio(
           java.lang.String cuil,
           int remNetImpAcum,
           int totPagAnt) {
           this.cuil = cuil;
           this.remNetImpAcum = remNetImpAcum;
           this.totPagAnt = totPagAnt;
    }


    /**
     * Gets the cuil value for this EmpleadoServicio.
     * 
     * @return cuil
     */
    public java.lang.String getCuil() {
        return cuil;
    }


    /**
     * Sets the cuil value for this EmpleadoServicio.
     * 
     * @param cuil
     */
    public void setCuil(java.lang.String cuil) {
        this.cuil = cuil;
    }


    /**
     * Gets the remNetImpAcum value for this EmpleadoServicio.
     * 
     * @return remNetImpAcum
     */
    public int getRemNetImpAcum() {
        return remNetImpAcum;
    }


    /**
     * Sets the remNetImpAcum value for this EmpleadoServicio.
     * 
     * @param remNetImpAcum
     */
    public void setRemNetImpAcum(int remNetImpAcum) {
        this.remNetImpAcum = remNetImpAcum;
    }


    /**
     * Gets the totPagAnt value for this EmpleadoServicio.
     * 
     * @return totPagAnt
     */
    public int getTotPagAnt() {
        return totPagAnt;
    }


    /**
     * Sets the totPagAnt value for this EmpleadoServicio.
     * 
     * @param totPagAnt
     */
    public void setTotPagAnt(int totPagAnt) {
        this.totPagAnt = totPagAnt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmpleadoServicio)) return false;
        EmpleadoServicio other = (EmpleadoServicio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cuil==null && other.getCuil()==null) || 
             (this.cuil!=null &&
              this.cuil.equals(other.getCuil()))) &&
            this.remNetImpAcum == other.getRemNetImpAcum() &&
            this.totPagAnt == other.getTotPagAnt();
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
        if (getCuil() != null) {
            _hashCode += getCuil().hashCode();
        }
        _hashCode += getRemNetImpAcum();
        _hashCode += getTotPagAnt();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmpleadoServicio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.operix.com.ar/", "EmpleadoServicio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remNetImpAcum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remNetImpAcum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totPagAnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totPagAnt"));
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
