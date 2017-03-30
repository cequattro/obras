package pe.gob.sunafil.envioCorrCongresales.util;



public abstract class BaseException extends Exception
{

    public BaseException(String message, Exception exception)
    {
        super(message);
        params = null;
        this.exception = exception;
        this.message = message;
    }

    public BaseException(String message, String params[], Exception exception)
    {
        super(message);
        this.params = null;
        this.exception = exception;
        this.message = message;
        this.params = params;
    }

    public BaseException(String message, String params[])
    {
        super(message);
        this.params = null;
        this.message = message;
        this.params = params;
    }

    public BaseException(Exception exception)
    {
        params = null;
        this.exception = exception;
    }

    public BaseException(Class source, String propertiesFileName, Throwable cause)
    {
        params = null;
    }

    public BaseException(String message)
    {
        super(message);
        params = null;
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public String[] getParams()
    {
        return params;
    }

    private Exception exception;
    private String message;
    private String params[];
    private String prueba;
    private String error11;
}
