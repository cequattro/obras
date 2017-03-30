/*
 * Created on Oct 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pe.gob.sunafil.envioCorrCongresales.util;

import java.util.ArrayList;

/**
 * @author Analisis
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ParameterCollection extends ArrayList {

	public ParameterCollection() {
	}

	public void addParameterInput(Parameter parameter) {
		add(parameter);
	}

	public void addParameterOutput(ParameterOutput parameter) {
		add(parameter);
	}

	public void addInput(Object object) {
		Parameter parameter = new Parameter();
		parameter.setDataValue(object);
		add(parameter);
	}

	public void addInput(Object object, int dataType) {
		Parameter parameter = new Parameter();
		parameter.setDataValue(object);
		parameter.setDatatype(dataType);
		add(parameter);
	}

	public void addOutput(int dataType) {
		ParameterOutput parameterOutput = new ParameterOutput(size(), dataType);
		add(parameterOutput);
	}

	public Parameter getValueInput(int index) {
		Parameter parameter = (Parameter) get(index);
		return parameter;
	}

	public int getDataType(int index) {
		ParameterOutput parameter = (ParameterOutput) get(index);
		return parameter.getDataType();
	}

}
