package com.demo.unitest;

import pe.gob.sunafil.gestionpersonal.utils.EnviarMail;

public class foo {
	static int i=0;
	public static void main(String... args) {		
		{
			++i;
			i+=i/(--i-1);
		}
		String[] direcciones=new String[1];		
		direcciones[0]="wcastro@sunafil.gob.pe";
		String mensaje="No se encontro DNI";								
		String asunto="Error grave web Service RENIEC RETCC VIRTUAL";
		EnviarMail enviarCorreo=new EnviarMail();
		try {
			enviarCorreo.generarEnvioDeCorreos(mensaje, direcciones,asunto);
		} catch (Exception e1) {					
			e1.printStackTrace();
			
		}
		
		System.out.println(i);		
	}
}
