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

