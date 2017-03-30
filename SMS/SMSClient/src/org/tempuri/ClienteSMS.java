package org.tempuri;

public class ClienteSMS {
	
	public ClienteSMS(){}
	
	public boolean enviarSMS(String titulo, String mensaje, String destinos)
	{
		final String endpoint = "http://ws1.pide.gob.pe/SMSService";
		SMSServiceSoapProxy proxy=new SMSServiceSoapProxy();
		proxy.setEndpoint(endpoint);
		SMSServiceSoap service=proxy.getSMSServiceSoap();
		try {
			boolean flag=service.sendSMS("SUNAFIL", titulo, mensaje, destinos, "01BEF2B50A686AAB1317B27BB77B86425F7A9DCF", "H8lEB3lWfaWk");
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}