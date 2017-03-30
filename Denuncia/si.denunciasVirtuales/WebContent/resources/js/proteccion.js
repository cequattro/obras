// Mensaje para blokear el boton derecho
var mensaje = "                             MTPE                  \n "+
			  " Ministerio de Trabajo y Promoción del Empleo \n "+			
			  "             Operación no Permitida.";
			  

/****************************
BOTON DERECHO
******************************/			  
function derecho(e)
{
   if (navigator.appName == 'Netscape' && e.which == 3)
      alert(mensaje);
   else if (navigator.appName == 'Microsoft Internet Explorer' && event.button==2)
      alert(mensaje);
}
document.onmousedown = derecho;


/****************************
IMPIDE COPIADO
******************************/
//Funciones para impedir el copiado del texto
function disableselect(e){
   return false
}
function reEnable(){
   return true
}
//if IE4+
//document.onselectstart=new Function ("return false")

//if NS6
/*if (window.sidebar){
   document.onmousedown=disableselect
   document.onclick=reEnable
}*/


/****************************
BLOQUEA TECLAS
******************************/
//Blokea Teclas CRL y ALT.
//event.keyCode == 16 || => para shift

function keyWhat(){
   //alert("event.keyCode => " +event.keyCode);
   if (navigator.appName == 'Microsoft Internet Explorer'){
        //For shift, ctrl and alt keys
        /*if(event.keyCode == 17 ||event.keyCode == 18 ){ 
          alert("No es necesario que utilices las teclas CTRL o ALT dentro del Sistema de Archivo Central.");
          return false;
        }*/        
        if (event.keyCode == 18){ //ALT
            alert("Acción no permitida");
            window.event.keyCode = 0;
            return false;          
        }
        if (event.keyCode == 115){ //F4
            alert("Acción no permitida");
            window.event.keyCode = 0;
            return false;          
        }
        if (event.keyCode == 116){ //F5
            alert("Acción no permitida");
            window.event.keyCode = 0;
            return false;
        }
        if (event.ctrlKey == true && event.keyCode == 85){ //Ctrl+U
            alert("Acción no permitida");
            window.event.keyCode = 0;
            return false;
        }
        if (event.ctrlKey == true && event.keyCode == 110){ //Ctrl+N
            alert("Acción no permitida");
            window.event.keyCode = 0;
            return false;            
        }
   }
}

document.onkeydown=keyWhat;


/****************************
MUEVE TEXTO BARRA ESTADO
******************************/
   var texto_estado = "             SUNAFIL. Copyright - 2015              "
   var posicion = 0
      
  function mueve_texto(){
      if (posicion < texto_estado.length) 
         posicion ++;
      else
         posicion = 1;
      string_actual = texto_estado.substring(posicion) + texto_estado.substring(0,posicion)
      window.status = string_actual
      setTimeout("mueve_texto()",150)
   }
   mueve_texto();

