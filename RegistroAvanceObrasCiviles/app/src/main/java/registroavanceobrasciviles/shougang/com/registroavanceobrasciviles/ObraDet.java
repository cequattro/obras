package registroavanceobrasciviles.shougang.com.registroavanceobrasciviles;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

/**
 * Created by Julio on 1/11/2016.
 */

public class ObraDet {
    private int mId;
    private int mIdCab;
    private String mDescripcion;
    private Date mFecha;
    private String mObservacion;
    private Double mAvance;
    private Double mLatitud;
    private Double mLongitud;

    public ObraDet(int id, int idCab, String descripcion, Date fecha, String observacion, Double avance, Double latitud, Double longitud) {
        mId = id;
        mIdCab = idCab;
        mDescripcion = descripcion;
        mFecha = fecha;
        mObservacion = observacion;
        mAvance = avance;
        mLatitud = latitud;
        mLongitud = longitud;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getIdCab() {
        return mIdCab;
    }

    public void setIdCab(int idCab) {
        mIdCab = idCab;
    }

    public Date getFecha(){
        return mFecha;
    }

    public void setFecha(Date fecha){
        mFecha = fecha;
    }

    public String getDescripcion(){
        return mDescripcion;
    }

    public void setDescripcion(String descripcion){
        mDescripcion = descripcion;
    }

    public String getObservacion(){
        return mObservacion;
    }

    public void setObservacion(String observacion){
        mObservacion = observacion;
    }

    public Double getAvance(){
        return mAvance;
    }

    public void setAvance(Double avance){
        mAvance = avance;
    }

    public Double getLatitud(){
        return mLatitud;
    }

    public void setLatitud(Double latitud){
        mLatitud = latitud;
    }

    public Double getLongitud(){
        return mLongitud;
    }

    public void setLongitud(Double longitud){
        mLongitud = longitud;
    }

    @Override
    public String toString() {
        return this.mDescripcion + " - " + this.mAvance.toString() + "%";
    }
}
