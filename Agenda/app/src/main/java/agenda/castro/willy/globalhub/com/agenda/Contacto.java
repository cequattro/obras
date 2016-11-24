package agenda.castro.willy.globalhub.com.agenda;

/**
 * Created by wcastro on 24/11/2016.
 */

public class Contacto {

    private String nombres;
    private String apellidos;
    private String edad;
    private String distrito;

    public Contacto() {
    }

    public Contacto(String nombres, String apellidos, String edad, String distrito) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.distrito = distrito;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
