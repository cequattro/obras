package castro.willy.globalhub.pe.apuestaamerica;

import android.graphics.Bitmap;

/**
 * Created by Android on 05/11/2016.
 */

public class Pais {

    private String nombre;
    private String descripcion;
    private int imagen;
    private Bitmap imagenBitmap;

    public Pais() {
    }

    public Pais(String nombre, String descripcion, int imagen, Bitmap imagenBitmap) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.imagenBitmap = imagenBitmap;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Bitmap getImagenBitmap() {
        return imagenBitmap;
    }

    public void setImagenBitmap(Bitmap imagenBitmap) {
        this.imagenBitmap = imagenBitmap;
    }
}
