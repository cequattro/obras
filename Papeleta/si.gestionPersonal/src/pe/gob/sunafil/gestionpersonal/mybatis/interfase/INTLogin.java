package pe.gob.sunafil.gestionpersonal.mybatis.interfase;

//import pe.gob.sunafil.tramiteext.bean.Demandapd;
//import pe.gob.sunafil.tramiteext.bean.Muestraemp;
import pe.gob.sunafil.gestionpersonal.bean.Periodo;

public interface INTLogin {
	
	public Periodo obtenerPeriodo() throws Exception;
//	public Demandapd obtenerDemandapd(Demandapd parametro) throws Exception;
//	public Muestraemp obtenerMuestra(Muestraemp parametro) throws Exception ;
}
