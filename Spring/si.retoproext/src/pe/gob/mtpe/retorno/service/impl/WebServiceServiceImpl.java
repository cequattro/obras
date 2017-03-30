package pe.gob.mtpe.retorno.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.dao.WebServiceDao;
import pe.gob.mtpe.retorno.service.WebServiceService;

@Service("webServiceService")
public class WebServiceServiceImpl implements WebServiceService {
	
	@Autowired
	private WebServiceDao webServiceDao;

	@Override
	public Map<String, String> obenterDatosServicio() throws Exception {		
		return webServiceDao.obenterDatosServicio();
	}

}
