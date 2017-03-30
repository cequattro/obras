package org.tempuri;

public class test {
	public static void main(String... args)
	{
		final String endpoint = "http://ws1.pide.gob.pe/SMSService";
		SMSServiceSoapProxy proxy=new SMSServiceSoapProxy();
		proxy.setEndpoint(endpoint);
		SMSServiceSoap service=proxy.getSMSServiceSoap();
		try {
			boolean flag=service.sendSMS("SUNAFIL", "MENSAJE", "mensaje prueba 04-12-2015 10:56 am", "986759398,979347563", "01BEF2B50A686AAB1317B27BB77B86425F7A9DCF", "H8lEB3lWfaWk");
			System.out.println("flag ::: "+flag);//949389629,948482009
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}