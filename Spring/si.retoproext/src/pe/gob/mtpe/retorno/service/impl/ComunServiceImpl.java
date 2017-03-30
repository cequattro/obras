package pe.gob.mtpe.retorno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.Departamento;
import pe.gob.mtpe.retorno.bean.Discapacidad;
import pe.gob.mtpe.retorno.bean.Distrito;
import pe.gob.mtpe.retorno.bean.Niveleducati;
import pe.gob.mtpe.retorno.bean.Ocupacion;
import pe.gob.mtpe.retorno.bean.Pais;
import pe.gob.mtpe.retorno.bean.ParamBus;
import pe.gob.mtpe.retorno.bean.Profesion;
import pe.gob.mtpe.retorno.bean.Provincia;
import pe.gob.mtpe.retorno.bean.Tdocide;
import pe.gob.mtpe.retorno.dao.ComunDao;
import pe.gob.mtpe.retorno.service.ComunService;

@Service("comunService")
public class ComunServiceImpl implements ComunService{
	
	@Autowired
	private ComunDao comunDao;

	@Override
	public List<Ocupacion> buscarOcupacion(ParamBus paramBus) throws Exception {		
		return comunDao.buscarOcupacion(paramBus);
	}

	@Override
	public List<Profesion> buscarProfesion(ParamBus paramBus) throws Exception {		
		return comunDao.buscarProfesion(paramBus);
	}

	@Override
	public List<Tdocide> listarTipoDocumento() throws Exception {		 
		return comunDao.listarTipoDocumento();
	}

	@Override
	public List<Departamento> ListaDepartamentos() throws Exception {
		return comunDao.ListaDepartamentos();
	}

	@Override
	public List<Provincia> ListaProvincias(Departamento departamento) throws Exception {
		return comunDao.ListaProvincias(departamento);
	}

	@Override
	public List<Distrito> ListaDistritos(Provincia provincia) throws Exception {
		return comunDao.ListaDistritos(provincia);
	}

	@Override
	public List<Pais> listaPais() throws Exception {		
		return comunDao.listaPais();
	}

	@Override
	public List<Discapacidad> listaDiscapacidad() throws Exception {		 
		return comunDao.listaDiscapacidad();
	}

	@Override
	public List<Niveleducati> listarNivelEducativo() throws Exception {		 
		return comunDao.listarNivelEducativo();
	}

}
