/**
 * ServiciosOperixServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.operix.www;

public class ServiciosOperixServiceLocator extends org.apache.axis.client.Service implements ar.com.operix.www.ServiciosOperixService {

    public ServiciosOperixServiceLocator() {
    }


    public ServiciosOperixServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiciosOperixServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiciosOperixPort
    private java.lang.String ServiciosOperixPort_address = "http://www.operix.com.ar/ServiciosOperix.php";

    public java.lang.String getServiciosOperixPortAddress() {
        return ServiciosOperixPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiciosOperixPortWSDDServiceName = "ServiciosOperixPort";

    public java.lang.String getServiciosOperixPortWSDDServiceName() {
        return ServiciosOperixPortWSDDServiceName;
    }

    public void setServiciosOperixPortWSDDServiceName(java.lang.String name) {
        ServiciosOperixPortWSDDServiceName = name;
    }

    public ar.com.operix.www.ServiciosOperixPortType getServiciosOperixPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiciosOperixPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiciosOperixPort(endpoint);
    }

    public ar.com.operix.www.ServiciosOperixPortType getServiciosOperixPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ar.com.operix.www.ServiciosOperixBindingStub _stub = new ar.com.operix.www.ServiciosOperixBindingStub(portAddress, this);
            _stub.setPortName(getServiciosOperixPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiciosOperixPortEndpointAddress(java.lang.String address) {
        ServiciosOperixPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ar.com.operix.www.ServiciosOperixPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ar.com.operix.www.ServiciosOperixBindingStub _stub = new ar.com.operix.www.ServiciosOperixBindingStub(new java.net.URL(ServiciosOperixPort_address), this);
                _stub.setPortName(getServiciosOperixPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServiciosOperixPort".equals(inputPortName)) {
            return getServiciosOperixPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.operix.com.ar/", "ServiciosOperixService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.operix.com.ar/", "ServiciosOperixPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiciosOperixPort".equals(portName)) {
            setServiciosOperixPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
