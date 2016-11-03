package registroavanceobrasciviles.shougang.com.registroavanceobrasciviles;

/**
 * Created by Julio on 1/11/2016.
 */

public class ObraCab {
    private int mId;
    private String mDescripcion;

    public ObraCab(int id, String descripcion){
        mId  = id;
        mDescripcion = descripcion;
    }

    public int getId(){
        return mId;
    }

    public void setId(int id){
        mId = id;
    }

    public String getDescripcion(){
        return mDescripcion;
    }

    public void setDescripcion(String descripcion){
        mDescripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.mId + ". " + this.mDescripcion;
    }
}
