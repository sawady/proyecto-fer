/**
 * ProyectoServicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.operix.www;

public class ProyectoServicio  implements java.io.Serializable {
    private int proyectoId;

    private java.lang.String proyectoNombre;

    private int horasEstimadas;

    private java.lang.String mailAutor;

    private int horasImputadas;

    public ProyectoServicio() {
    }

    public ProyectoServicio(
           int proyectoId,
           java.lang.String proyectoNombre,
           int horasEstimadas,
           java.lang.String mailAutor,
           int horasImputadas) {
           this.proyectoId = proyectoId;
           this.proyectoNombre = proyectoNombre;
           this.horasEstimadas = horasEstimadas;
           this.mailAutor = mailAutor;
           this.horasImputadas = horasImputadas;
    }


    /**
     * Gets the proyectoId value for this ProyectoServicio.
     * 
     * @return proyectoId
     */
    public int getProyectoId() {
        return proyectoId;
    }


    /**
     * Sets the proyectoId value for this ProyectoServicio.
     * 
     * @param proyectoId
     */
    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }


    /**
     * Gets the proyectoNombre value for this ProyectoServicio.
     * 
     * @return proyectoNombre
     */
    public java.lang.String getProyectoNombre() {
        return proyectoNombre;
    }


    /**
     * Sets the proyectoNombre value for this ProyectoServicio.
     * 
     * @param proyectoNombre
     */
    public void setProyectoNombre(java.lang.String proyectoNombre) {
        this.proyectoNombre = proyectoNombre;
    }


    /**
     * Gets the horasEstimadas value for this ProyectoServicio.
     * 
     * @return horasEstimadas
     */
    public int getHorasEstimadas() {
        return horasEstimadas;
    }


    /**
     * Sets the horasEstimadas value for this ProyectoServicio.
     * 
     * @param horasEstimadas
     */
    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }


    /**
     * Gets the mailAutor value for this ProyectoServicio.
     * 
     * @return mailAutor
     */
    public java.lang.String getMailAutor() {
        return mailAutor;
    }


    /**
     * Sets the mailAutor value for this ProyectoServicio.
     * 
     * @param mailAutor
     */
    public void setMailAutor(java.lang.String mailAutor) {
        this.mailAutor = mailAutor;
    }


    /**
     * Gets the horasImputadas value for this ProyectoServicio.
     * 
     * @return horasImputadas
     */
    public int getHorasImputadas() {
        return horasImputadas;
    }


    /**
     * Sets the horasImputadas value for this ProyectoServicio.
     * 
     * @param horasImputadas
     */
    public void setHorasImputadas(int horasImputadas) {
        this.horasImputadas = horasImputadas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProyectoServicio)) return false;
        ProyectoServicio other = (ProyectoServicio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.proyectoId == other.getProyectoId() &&
            ((this.proyectoNombre==null && other.getProyectoNombre()==null) || 
             (this.proyectoNombre!=null &&
              this.proyectoNombre.equals(other.getProyectoNombre()))) &&
            this.horasEstimadas == other.getHorasEstimadas() &&
            ((this.mailAutor==null && other.getMailAutor()==null) || 
             (this.mailAutor!=null &&
              this.mailAutor.equals(other.getMailAutor()))) &&
            this.horasImputadas == other.getHorasImputadas();
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
        _hashCode += getProyectoId();
        if (getProyectoNombre() != null) {
            _hashCode += getProyectoNombre().hashCode();
        }
        _hashCode += getHorasEstimadas();
        if (getMailAutor() != null) {
            _hashCode += getMailAutor().hashCode();
        }
        _hashCode += getHorasImputadas();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProyectoServicio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.operix.com.ar/", "ProyectoServicio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proyectoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proyectoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proyectoNombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proyectoNombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horasEstimadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horasEstimadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailAutor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mailAutor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horasImputadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horasImputadas"));
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
