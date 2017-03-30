/*
 * Created on 17-feb-2005
 *
 */
package pe.gob.sunafil.envioCorrCongresales.util;

/**
 * @author Noe Saldaña
 *
 * 
 */
public class QueryException extends BaseException {
	
	public QueryException(String message, Exception exception){
		 super(message,exception);
	}

	public QueryException(String message){
		this(message, null);
	}

	public QueryException(Exception exception) {
		 this(null, exception);
	}
	
}
