package pe.gob.sunafil.envioCorrCongresales.util;


import java.util.Date;

public class Encriptar {
	
    public Encriptar() {
    }
    
     
     
    public String Encriptar(String pLogin, String pClave) {
        
        int li_Cont = 0, li_Magia = 0, li_Long = 0, li_Char = 0, li_Ascii1 = 0, li_Ascii2 = 0, li_Signo = 0;
        String ls_Login = "", ls_Clave = "", ls_Cripto = "", ls_Result = "";
        
        //logger.info("=> Igualamos las dos cadenas");
        if(pLogin.trim().length() > pClave.trim().length()){
            ls_Login = pLogin;
            String temp = pClave + pClave + pClave + pClave;
            ls_Clave = temp.substring(0, ls_Login.length());                    
        }else{
            ls_Clave = pClave;
            String temp = pLogin + pLogin + pLogin + pLogin;
            ls_Login = temp.substring(0, ls_Clave.length());                    
        }
                
        li_Long = ls_Login.length();

        
        //logger.info("=> Generamos número mágico");
        for(li_Cont = 0; li_Cont < li_Long; li_Cont++){               
            li_Magia = ((li_Magia + getAscii(ls_Login.substring(li_Cont,  li_Cont+1)))%255)+1;                  
        }    
        li_Magia = ((li_Magia + total_segundos())%255) + 1;    

                
        //logger.info("=> Encriptamos por primera vez");
        for(li_Cont = 0; li_Cont < li_Long; li_Cont++){   
                li_Ascii1 = getAscii(ls_Login.substring(li_Cont,li_Cont+1));
                li_Ascii2 = getAscii(ls_Clave.substring(li_Cont,li_Cont+1));                
                li_Char   = li_Ascii2 + li_Ascii1 + li_Magia;
                ls_Cripto = ls_Cripto + completa_codigo(""+li_Char,3);
        }                
        ls_Cripto = ls_Cripto + completa_codigo(""+li_Magia,3)+ completa_codigo(""+pClave.length(),2);                
        

        //logger.info("Encriptamos por segunda vez");
        for(li_Cont = 1; li_Cont <= ls_Cripto.length(); li_Cont++){   
            if(li_Cont%2==0){
                li_Signo = 1;
            }else{
                li_Signo = -1;
            } 
            li_Char   = getAscii(ls_Cripto.substring(li_Cont-1, li_Cont));    
            ls_Result = ls_Result + ascii_to_string(li_Char+(li_Long*li_Signo));                 
        }  
 
        return ls_Result;
     }
     
      public String Desencriptar(String pLogin, String pCripto) {

        int li_Cont=0, li_Magia=0, li_Long=0, li_Ascii1=0, li_Ascii2=0, li_Char=0, li_Signo=0;
        String ls_Login="", ls_Cripto="";

       // logger.info("Desencriptamos por primera vez");
        li_Long = (pCripto.length()-5)/3;
        for(li_Cont = 1; li_Cont <= pCripto.length(); li_Cont++){
                if((li_Cont%2) == 0){
                    li_Signo = 1;
                }else{
                    li_Signo = -1;
                } 
                li_Char = getAscii(pCripto.substring(li_Cont-1, li_Cont));
                ls_Cripto = ls_Cripto + ascii_to_string(li_Char-(li_Long*li_Signo));            
        }
        
        
        //logger.info("Igualamos las dos cadenas");        
        li_Long  = Integer.parseInt(ls_Cripto.substring(ls_Cripto.length()-2, ls_Cripto.length()));        
        pLogin = pLogin + pLogin + pLogin + pLogin;         
        pLogin = pLogin.substring(0, li_Long);
        
                
        //logger.info("Obtenemos número mágico");
        li_Magia = Integer.parseInt(ls_Cripto.substring(ls_Cripto.length()- 5, ls_Cripto.length()-2));        

        
        //logger.info("Desencriptamos por segunda vez");
        for(li_Cont = 1; li_Cont <= li_Long; li_Cont++){
                li_Ascii1 = getAscii(pLogin.substring(li_Cont-1, li_Cont));
                li_Ascii2 = Integer.parseInt(ls_Cripto.substring((li_Cont*3)-3, li_Cont*3));
                ls_Login  = ls_Login + ascii_to_string(li_Ascii2-li_Ascii1-li_Magia);
        }
        
        return ls_Login;
      }
     
     
     public int getAscii(String valor){
           int j = (int) valor.charAt(0);
           //System.out.println(j);
           return j;
        
     }
     
     public int total_segundos(){             
             Date now = new Date();   
             /*logger.info("horas => "+now.getHours());            
             logger.info("minuts => "+now.getMinutes());            
             logger.info("segundos => "+now.getSeconds());    
             */
             int cant = (Integer.parseInt(""+now.getHours()*3600)) + (Integer.parseInt(""+now.getMinutes()*60))+ Integer.parseInt(""+now.getSeconds()); 
             //logger.info("Cantidad => "+cant); 
             
             return cant;
    }
     
    public String completa_codigo(String codigo, int tamanio){
        String ncodigo = "";        
                
        if(codigo.length() >= tamanio){
            for(int i=0; i< tamanio; i++){
                ncodigo = ncodigo + codigo.charAt(i);
            }       
        }else{
            for(int i=0; i<tamanio-codigo.length(); i++){
                ncodigo = ncodigo +"0";
            }
            ncodigo = ncodigo + codigo;        
        }        
        
        return ncodigo;
    }
 
    public String ascii_to_string(int i){        
        return new Character((char)i).toString();
    }
   
   
}
