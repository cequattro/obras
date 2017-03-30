package pe.gob.mtpe.retorno.prime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class RetornoDataModel extends ListDataModel<Map> implements SelectableDataModel<Map>{
	
	
	public RetornoDataModel(){
		
	}
	
	public RetornoDataModel(List<Map> data){
		super(data);
		
	}

	@Override
	public Map getRowData(String rowKey) {
		
		List<Map> lista=(List<Map> )getWrappedData();
		
		for(int i=0;i<lista.size();i++){
			Map dato=new HashMap<String, Object>();
			dato=lista.get(i);
			if(rowKey.equals(dato.get("V_CODTDOCIDE").toString()+dato.get("VNUMDOC").toString())){
				return dato;
			}
		}
		
		return null;
	}

	@Override
	public Object getRowKey(Map dPersona) {
		
		Object key=dPersona.get("V_CODTDOCIDE").toString()+dPersona.get("VNUMDOC").toString();
		
		return key;
	}

}
