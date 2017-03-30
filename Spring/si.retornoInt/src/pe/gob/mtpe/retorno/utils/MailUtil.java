package pe.gob.mtpe.retorno.utils;

import java.util.Map;

public class MailUtil {

	public static String getMessageFormat(Map datos, String cuerpoMensaje, String urlMensa) {
		String textoMensaje = "";
		textoMensaje = "<p>Estimado(a) {PERSONA}" + "" + ":<br/></p>";
		textoMensaje += "<p> {CUERPO}<br/></p>";
		textoMensaje += "<br/><p>Si desea realizar alguna consulta {URL}<br/></p>";
		textoMensaje += "<br/><p>{FIRMA}<br/></p>";

		String url = "<a href='" + urlMensa + "/{TIPODOC}" + "" + "/{DOCUMENTO}" + " " + "' target='_blank'>";
		url += "Haga clic aqui";
		url += "</a>";

		String firma = "DIRECCIÓN DE MIGRACIÓN LABORAL<br/> Ministerio de Trabajo y Promoción del Empleo<br/> Av. Salaverry 655 - Piso 6";
		String personaDirig = datos.get("VNOMBRES") == null ? "" : datos.get("VNOMBRES").toString();
		
		url=url.replace("{TIPODOC}", datos.get("V_CODTDOCIDE").toString());
		url=url.replace("{DOCUMENTO}", datos.get("VNUMDOC").toString());
		
		textoMensaje = textoMensaje.replace("{PERSONA}", personaDirig);
		textoMensaje = textoMensaje.replace("{CUERPO}", cuerpoMensaje);
		textoMensaje = textoMensaje.replace("{URL}", url);
		textoMensaje = textoMensaje.replace("{FIRMA}", firma);

		return textoMensaje;
	}

}
