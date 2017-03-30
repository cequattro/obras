package org.tempuri;

public class SMSServiceSoapProxy implements org.tempuri.SMSServiceSoap {
  private String _endpoint = null;
  private org.tempuri.SMSServiceSoap sMSServiceSoap = null;
  
  public SMSServiceSoapProxy() {
    _initSMSServiceSoapProxy();
  }
  
  public SMSServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSMSServiceSoapProxy();
  }
  
  private void _initSMSServiceSoapProxy() {
    try {
      sMSServiceSoap = (new org.tempuri.SMSService_vs0Locator()).getSMSServicePortS();
      if (sMSServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sMSServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sMSServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sMSServiceSoap != null)
      ((javax.xml.rpc.Stub)sMSServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.SMSServiceSoap getSMSServiceSoap() {
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap;
  }
  
  public boolean sendSMS(java.lang.String sender, java.lang.String subject, java.lang.String message, java.lang.String receiver, java.lang.String key, java.lang.String login) throws java.rmi.RemoteException{
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap.sendSMS(sender, subject, message, receiver, key, login);
  }
  
  
}