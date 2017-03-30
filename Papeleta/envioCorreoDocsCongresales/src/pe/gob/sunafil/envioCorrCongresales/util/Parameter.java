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
public final class Parameter {

	public Parameter() {
		params = new ArrayList();
		datatype = 12;
	}

	public int getDatatype() {
		return datatype;
	}

	public Object getDataValue() {
		return dataValue;
	}

	public void setDatatype(int dataType) {
		datatype = dataType;
	}

	public void setDataValue(Object object) {
		dataValue = object;
	}

	private ArrayList params;

	private int datatype;

	private Object dataValue;

}
