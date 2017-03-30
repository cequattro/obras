/**
 * SMSServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface SMSServiceSoap extends java.rmi.Remote {
    public boolean sendSMS(java.lang.String sender, java.lang.String subject, java.lang.String message, java.lang.String receiver, java.lang.String key, java.lang.String login) throws java.rmi.RemoteException;
}
