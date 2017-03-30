package pe.gob.mtpe.retorno.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mtpe.retorno.bean.ParamReporte;
import pe.gob.mtpe.retorno.dao.ReporteDao;
import pe.gob.mtpe.retorno.service.ReporteService;


@Service("reporteService")
public class ReporteServiceImpl implements ReporteService{
	
	@Autowired
	private ReporteDao reporteDao;

	@Override
	public List<Map> mostrarReprote1(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote1(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote2(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote2(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote3(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote3(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote4(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote4(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote5(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote5(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote6(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote6(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote7(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote7(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote8(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote8(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote9(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote9(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote10(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote10(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote11(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote11(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote12(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote12(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote13(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote13(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote14(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote14(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote15(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote15(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote16(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote16(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote17(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote17(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote18(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote18(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote19(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote19(paramReporte) ;
	}

	@Override
	public List<Map> mostrarReprote20(ParamReporte paramReporte) throws Exception {
		return reporteDao.mostrarReprote20(paramReporte) ;
	}
	
	
	

}
