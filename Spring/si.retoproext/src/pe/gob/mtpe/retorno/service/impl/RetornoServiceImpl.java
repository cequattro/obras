package pe.gob.mtpe.retorno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.DPersona;
import pe.gob.mtpe.retorno.bean.Familia;
import pe.gob.mtpe.retorno.bean.Rango;
import pe.gob.mtpe.retorno.bean.Retorno;
import pe.gob.mtpe.retorno.dao.RetornoDao;
import pe.gob.mtpe.retorno.service.RetornoService;

@Service("retornoService")
public class RetornoServiceImpl implements RetornoService{
	
	@Autowired
	RetornoDao retornoDao;

	@Override
	public List<Retorno> listarMotivos() throws Exception {
	
		return retornoDao.listarMotivos();
	}

	@Override
	public void insertardPersona(DPersona dPersona) throws Exception {
		retornoDao.eliminarFamilia(dPersona);
		retornoDao.eliminardPersona(dPersona);
		retornoDao.insertardPersona(dPersona);		
		if("S".equals(dPersona.getvFlgretfam())){
			 
			for(int i=0;i<dPersona.getLstHijos().size();i++){
				retornoDao.insertaFamilia(dPersona.getLstHijos().get(i));
			}	
			
		}
		
		
	}

	@Override
	public List<Rango> listarRango(Rango pRango) throws Exception {		 
		return retornoDao.listarRango(pRango);
	}

	@Override
	public Integer consultaNumeroRegistros(DPersona dPersona) throws Exception {		
		return retornoDao.consultaNumeroRegistros(dPersona);
	}

	@Override
	public DPersona cargarDPersona(DPersona dpersona) throws Exception {
		
		return retornoDao.cargarDPersona(dpersona);
	}

	@Override
	public Retorno CargarMotivoRetorno(DPersona dpersona) throws Exception {
		 
		return  retornoDao.CargarMotivoRetorno(dpersona);
	}

	@Override
	public List<Familia> cargarHijoRetorno(DPersona dpersona) throws Exception {		 
		return retornoDao.cargarHijoRetorno(dpersona);
	}

 
	
	

}
