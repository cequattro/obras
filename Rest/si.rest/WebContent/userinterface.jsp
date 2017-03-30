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
function consumirParaJson(keyword)
{//se llama a localhost como destino
	var url="http://localhost:8080/si.rest/restServlet?salida=application/json";
	$.get(url , function( data ) {	
                //alert(data);
		var str="Resultados<br>";
		var aResult=new Array();
		aResult=data.list;
		for (var i = 0; i < aResult.length; i++) {
			var array_element = aResult[i];
			str+="<br>Elemento "+(i+1)+": "+array_element;
		}				
		$( "#result" ).html(str);
		}, "json" );	
}
</script>
</head>
<body>
<input type="hidden" id="txtPalabraClave" value="">
<br>
<a href="#" onclick="consumirParaJson($('#txtPalabraClave').val());">Obtener Listado</a>
<br><br>
<div id="result">
</div>
</body>
</html>