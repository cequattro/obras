/**
 * SMSService_vs0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface SMSService_vs0 extends javax.xml.rpc.Service {
    public java.lang.String getSMSServicePortSAddress();

    public org.tempuri.SMSServiceSoap getSMSServicePortS() throws javax.xml.rpc.ServiceException;

    public org.tempuri.SMSServiceSoap getSMSServicePortS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getSMSServicePortAddress();

    public org.tempuri.SMSServiceSoap getSMSServicePort() throws javax.xml.rpc.ServiceException;

    public org.tempuri.SMSServiceSoap getSMSServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
