/**
 * HorarioIE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.operix.www;

public class HorarioIE  implements java.io.Serializable {
    private int recursoId;

    private int fechaHora;

    private java.lang.String movimiento;

    private java.lang.String tipo;

    public HorarioIE() {
    }

    public HorarioIE(
           int recursoId,
           int fechaHora,
           java.lang.String movimiento,
           java.lang.String tipo) {
           this.recursoId = recursoId;
           this.fechaHora = fechaHora;
           this.movimiento = movimiento;
           this.tipo = tipo;
    }


    /**
     * Gets the recursoId value for this HorarioIE.
     * 
     * @return recursoId
     */
    public int getRecursoId() {
        return recursoId;
    }


    /**
     * Sets the recursoId value for this HorarioIE.
     * 
     * @param recursoId
     */
    public void setRecursoId(int recursoId) {
        this.recursoId = recursoId;
    }


    /**
     * Gets the fechaHora value for this HorarioIE.
     * 
     * @return fechaHora
     */
    public int getFechaHora() {
        return fechaHora;
    }


    /**
     * Sets the fechaHora value for this HorarioIE.
     * 
     * @param fechaHora
     */
    public void setFechaHora(int fechaHora) {
        this.fechaHora = fechaHora;
    }


    /**
     * Gets the movimiento value for this HorarioIE.
     * 
     * @return movimiento
     */
    public java.lang.String getMovimiento() {
        return movimiento;
    }


    /**
     * Sets the movimiento value for this HorarioIE.
     * 
     * @param movimiento
     */
    public void setMovimiento(java.lang.String movimiento) {
        this.movimiento = movimiento;
    }


    /**
     * Gets the tipo value for this HorarioIE.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this HorarioIE.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HorarioIE)) return false;
        HorarioIE other = (HorarioIE) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.recursoId == other.getRecursoId() &&
            this.fechaHora == other.getFechaHora() &&
            ((this.movimiento==null && other.getMovimiento()==null) || 
             (this.movimiento!=null &&
              this.movimiento.equals(other.getMovimiento()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo())));
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
        _hashCode += getRecursoId();
        _hashCode += getFechaHora();
        if (getMovimiento() != null) {
            _hashCode += getMovimiento().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HorarioIE.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.operix.com.ar/", "HorarioIE"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recursoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recursoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "movimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
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
