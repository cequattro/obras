function isNumberKey(evt){   
	 
    			 var charCode = (evt.which) ? evt.which : event.keyCode;
    			 if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    				 return false;
    			 }   				
    			    
    			 return true;
 }

function sololetra(evt){
	
	 var charCode = (evt.which) ? evt.which : event.keyCode;
	
	if ( charCode == 32 ) return true;  //barra espaciadora	
	if ( charCode == 39 ) return true;  //�
	if ( charCode == 241 ) return true;  //�esto funciona ocn mi maquina que esta con esppa�ol peru 
	if ( charCode == 209 ) return true;  //�	
	if ( charCode > 64 && charCode < 91 ) return true;//letras mayusculas
	if ( charCode > 96 && charCode < 123) return true;//letras min�sculas	
	
	return false;	//todo lo demas negado
}

	
	
function soloNumeros(e) {
	var key = window.event ? window.event.keyCode : e.which;
	return (key <= 13 || (key >= 48 && key <= 57));
}

function soloNumerosDecimal(e,textbox) {
	var key = window.event ? window.event.keyCode : e.which;
	//alert(key);
	//return (key <= 13 || (key >= 48 && key <= 57));
	
	if (key <= 13 || (key >= 48 && key <= 57)) return  true;
	var cadena = textbox.value;
	alert(cadena);
    if ( cadena.indexOf( '.' ) != -1 ) {
    	//alert("cadena.indexOf != -1")
    	return false; 
    }
	if(key == 46) return true;
	return false;
	
}



/// <summary>
/// Validamos el número de enteros y decimales
/// </summary>
/// <param name="el">Elemento que lanza el método</param>
/// <param name="evt">Evneto</param>
/// <param name="ints">Número de enteros permitidos</param>
/// <param name="decimals">Número de decimales permitidos</param>
function soloNumerosDecimalesLimit(el, evt, ints, decimals) {

  // La coma lo cambiamos por el punto
  if (evt.keyCode == 44) {//46
      evt.keyCode = 46;//44
  }
  
  // Valores numéricos
  var charCode = (evt.which) ? evt.which : event.keyCode;
  if (charCode != 46 && charCode > 31
      && (charCode < 48 || charCode > 57)) {
      return false;
  }
  
  // Sólo una coma
  if (charCode == 46) {
      if (el.value.indexOf(".") !== -1) {
          return false;
      }

      return true;
  }

  // Determinamos si hay decimales o no
  if (el.value.indexOf(".") == -1) {
      // Si no hay decimales, directamente comprobamos que el número que hay ya supero el número de enteros permitidos
      if (el.value.length >= ints) {
          return false;
      }
  }
  else {
	  var posi = el.value.indexOf(".");
	  var tam = el.value.length;
	  //alert(posi);
	  if (posi == 5) return false;
	  
	  
      // Damos el foco al elemento
      el.focus();

      // Para obtener la posición del cursor, obtenemos el rango de la selección vacía
      var oSel = document.selection.createRange();
      
            

      // Movemos el inicio de la selección a la posición 0
      oSel.moveStart('character', -el.value.length);

      // La posición de caret es la longitud de la selección
      iCaretPos = oSel.text.length;

      // Distancia que hay hasta la coma
      var dec = el.value.indexOf(".");

      // Si la posición es anterior a los decimales, el cursor está en la parte entera
      if (iCaretPos <= dec) {
          // Obtenemos la longitud que hay desde la posición 0 hasta la coma, y comparamos
          if (dec >= ints) {
              return false;
          }
      }
      else { // El cursor está en la parte decimal
          // Obtenemos la longitud de decimales (longitud total menos distancia hasta la coma menos el carácter coma)
          var numDecimals = el.value.length - dec - 1;
              
          if (numDecimals >= decimals) {
              return false;
          }
      }
  }
  
  return true;
}



function soloLetraNumDir(evt){
	var charCode = (evt.which) ? evt.which : event.keyCode;
	
	if ( charCode == 32 ) return true;  //barra espaciadora	
	if ( charCode == 39 ) return true;  //�
	if ( charCode == 241 ) return true;  //�esto funciona ocn mi maquina que esta con esppa�ol peru 
	if ( charCode == 209 ) return true;  //�	
	if ( charCode > 64 && charCode < 91 ) return true;//letras mayusculas
	if ( charCode > 96 && charCode < 123) return true;//letras min�sculas	

	if ( charCode > 47 && charCode < 58 ) return true;//numeros
	if (charCode == 43 || charCode == 45 || charCode == 47 ) return true;//son el "+" y el "-" y el "/"
	
	return false;	//todo lo demas negado
}

function soloNumLetTelelf(evt){
	var charCode = (evt.which) ? evt.which : event.keyCode;
	
	if ( charCode == 32 ) return true;  //barra espaciadora
	if ( charCode > 47 && charCode < 58 ) return true;//numeros
	if (charCode == 43 || charCode == 45 || charCode == 40 || charCode == 41 ) return true;//son el "+" y el "-" y el "(" y el ")"
	
	return false;	//todo lo demas negado
}

function isNumberKeyNL(evt){
	 
	 var charCode = (evt.which) ? evt.which : event.keyCode;	 
	 var tipo =v_codtdocide.value;	 
		if(tipo=="03"){	
			
			evt.maxLength = 8;
				if (charCode != 31 && (charCode < 48 || charCode > 57)){					
					 return false;
				 	}
				 else {
					 return true;
					}
		}else if(tipo=="09"){
			evt.maxLength = 11;
 			if (charCode != 31 && (charCode < 48 || charCode > 57)){
				 return false;
			 	}
			 else {
				 return true;
				}
		}else {
			evt.maxLength = 15;
			if ( charCode == 32 ) return false; //para que no ingrese espacios
			if ( charCode > 47 && charCode < 58 ) return true;//numeros
			if ( charCode > 64 && charCode < 91 ) return true;//letras mayusculas
			if ( charCode > 96 && charCode < 123) return true;//letras min�sculas
			if (charCode == 43 || charCode == 45) return true;//son el "+" y el "-"
			return false;	//todo lo demas negado
		}
	}


