<%-- 
    Document   : userinterface
    Created on : 21/01/2016, 12:40:34 PM
    Author     : wcastro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumir Json</title>
<script src="jquery-ui/js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" href="jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.min.css" />
<script src="jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
<script>
function consumirParaJson(nroHR,anioHR,dependenciaHR)
{//se llama a un ip o dominio distinto a localhost
	//var url="http://10.1.50.41:8080/si.restTramite/restTramite?salida=application/json&nro="+nroHR+"&anio="+anioHR;
	var url="http://10.1.50.39:8080/si.restTramite/restTramite?salida=application/json&nro="+nroHR+"&anio="+anioHR+"&dependencia="+dependenciaHR;
	$.get(url , function( data ) {	
		var str="Resultado<br>";
		var aResult=new Array();
		str+="<br>vCodentidad: "+data.entidad.vCodentidad;
		str+="<br>vCodtipodocid: "+data.entidad.vCodtipodocid;
		str+="<br>vDesnombre: "+data.entidad.vDesnombre;				
		str+="<br>vApepat: "+data.entidad.vApepat;
		str+="<br>vApemat: "+data.entidad.vApemat;
		str+="<br>vNombres: "+data.entidad.vNombres;
		str+="<br>dFecemision: "+data.registro.dFecemision;
		str+="<br>Error: "+data.errorCode+" ::: "+data.errorMessage;
		$( "#result" ).html(str);
		}, "json" );	
}
</script>
</head>
<body>
Nro<input type="text" id="nroHR" value="">
<br>
Anio<input type="text" id="anioHR" value="">
<br>
Dependencia<input type="text" id="dependenciaHR" value="">
<br>
<a href="#" onclick="consumirParaJson($('#nroHR').val(),$('#anioHR').val(),$('#dependenciaHR').val());">Obtener Listado</a>
<br><br>
<div id="result">
</div>
</body>
</html>