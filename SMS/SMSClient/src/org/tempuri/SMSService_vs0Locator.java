/**
 * SMSService_vs0Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SMSService_vs0Locator extends org.apache.axis.client.Service implements org.tempuri.SMSService_vs0 {

    public SMSService_vs0Locator() {
    }


    public SMSService_vs0Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SMSService_vs0Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SMSServicePortS
    private java.lang.String SMSServicePortS_address = "http://ws1.pide.gob.pe/SMSService";//"https://10.0.1.117:9953/SMSServiceS";

    public java.lang.String getSMSServicePortSAddress() {
        return SMSServicePortS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SMSServicePortSWSDDServiceName = "SMSServicePortS";

    public java.lang.String getSMSServicePortSWSDDServiceName() {
        return SMSServicePortSWSDDServiceName;
    }

    public void setSMSServicePortSWSDDServiceName(java.lang.String name) {
        SMSServicePortSWSDDServiceName = name;
    }

    public org.tempuri.SMSServiceSoap getSMSServicePortS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SMSServicePortS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSMSServicePortS(endpoint);
    }

    public org.tempuri.SMSServiceSoap getSMSServicePortS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.SMSServiceSoapStub _stub = new org.tempuri.SMSServiceSoapStub(portAddress, this);
            _stub.setPortName(getSMSServicePortSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSMSServicePortSEndpointAddress(java.lang.String address) {
        SMSServicePortS_address = address;
    }


    // Use to get a proxy class for SMSServicePort
    private java.lang.String SMSServicePort_address = "http://ws1.pide.gob.pe/SMSService";//"http://10.0.1.117:9951/SMSService";

    public java.lang.String getSMSServicePortAddress() {
        return SMSServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SMSServicePortWSDDServiceName = "SMSServicePort";

    public java.lang.String getSMSServicePortWSDDServiceName() {
        return SMSServicePortWSDDServiceName;
    }

    public void setSMSServicePortWSDDServiceName(java.lang.String name) {
        SMSServicePortWSDDServiceName = name;
    }

    public org.tempuri.SMSServiceSoap getSMSServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SMSServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSMSServicePort(endpoint);
    }

    public org.tempuri.SMSServiceSoap getSMSServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.SMSServiceSoapStub _stub = new org.tempuri.SMSServiceSoapStub(portAddress, this);
            _stub.setPortName(getSMSServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSMSServicePortEndpointAddress(java.lang.String address) {
        SMSServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.SMSServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.SMSServiceSoapStub _stub = new org.tempuri.SMSServiceSoapStub(new java.net.URL(SMSServicePortS_address), this);
                _stub.setPortName(getSMSServicePortSWSDDServiceName());
                return _stub;
            }
            if (org.tempuri.SMSServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.SMSServiceSoapStub _stub = new org.tempuri.SMSServiceSoapStub(new java.net.URL(SMSServicePort_address), this);
                _stub.setPortName(getSMSServicePortWSDDServiceName());
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
        if ("SMSServicePortS".equals(inputPortName)) {
            return getSMSServicePortS();
        }
        else if ("SMSServicePort".equals(inputPortName)) {
            return getSMSServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "SMSService_vs0");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "SMSServicePortS"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "SMSServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SMSServicePortS".equals(portName)) {
            setSMSServicePortSEndpointAddress(address);
        }
        else 
if ("SMSServicePort".equals(portName)) {
            setSMSServicePortEndpointAddress(address);
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
