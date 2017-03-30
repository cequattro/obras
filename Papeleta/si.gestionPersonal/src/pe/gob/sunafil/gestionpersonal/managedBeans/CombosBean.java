package pe.gob.sunafil.gestionpersonal.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import pe.gob.sunafil.gestionpersonal.bean.Combo;
import pe.gob.sunafil.gestionpersonal.mybatis.despachadores.CombosDespatch;

@ManagedBean(name="combosBean")
@SessionScoped
public class CombosBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3120298444112164123L;
	private static Logger logger = Logger.getLogger(CombosBean.class.getName());
	
	private List<Combo> listaTipoDocumentos;
	private List<Combo> listaDepartamentos;
	private List<Combo> listaTipoZonas;
	private List<Combo> listaTipoVias;
	private List<Combo> listaIntendencias;
	
	private CombosDespatch dspcombos;
	
	/**
	 * Constructor
	 */
	public CombosBean(){
		logger.info("Inicializando Con el Constructor de CombosBean");;
	}
	
	/**
     * Método que retorna una lista de tipo de documentos.
     * @return Lista de Combo de tipos de documentos.
     */	
	public List<Combo> getListaTipoDocumentos() {
		try{
			if(listaTipoDocumentos==null){				
				listaTipoDocumentos=new ArrayList<Combo>();
				dspcombos=new CombosDespatch();
				listaTipoDocumentos=dspcombos.listaComboXTipo("TipoDocIde");
			}
		} catch (Exception e) {
			logger.error("Error en Listar Tipos de Documento: "+e.getMessage(),e);
		}
		return listaTipoDocumentos;
	}
	
	public List<Combo> getListaDepartamentos() {
		try{
			if(listaDepartamentos==null){				
				listaDepartamentos=new ArrayList<Combo>();
				dspcombos=new CombosDespatch();
				listaDepartamentos=dspcombos.listaComboXTipo("Departamento");
			}
		} catch (Exception e) {
			logger.error("Error en Listar los Departemanetos: "+e.getMessage(),e);
		}
		return listaDepartamentos;
	}
	
	public List<Combo> getListaTipoZonas() {
		try{
			if(listaTipoZonas==null){				
				listaTipoZonas=new ArrayList<Combo>();
				dspcombos=new CombosDespatch();
				listaTipoZonas=dspcombos.listaComboXTipo("TipoZona");					
			}
		} catch (Exception e) {
			logger.error("Error en Listar Tipos de Zonas: "+e.getMessage(),e);
		}
		return listaTipoZonas;
	}
	
	public List<Combo> getListaTipoVias() {
		try{
			if(listaTipoVias==null){				
				listaTipoVias=new ArrayList<Combo>();
				dspcombos=new CombosDespatch();
				listaTipoVias=dspcombos.listaComboXTipo("TipoVia");
			}
		} catch (Exception e) {
			logger.error("Error en Listar Tipos de Vías: "+e.getMessage(),e);
		}
		return listaTipoVias;
	}
	
	public List<Combo> getListaIntendencias() {
		try{
			if(listaIntendencias==null){				
				listaIntendencias=new ArrayList<Combo>();
				dspcombos=new CombosDespatch();
				listaIntendencias=dspcombos.listaComboXTipo("Intendencia");
			}
		} catch (Exception e) {
			logger.error("Error en Listar las Intendencias: "+e.getMessage(),e);
		}
		return listaIntendencias;
	}
	
}
