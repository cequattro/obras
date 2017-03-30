/*
 * Created on Oct 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pe.gob.sunafil.envioCorrCongresales.util;
/**
 * @author Analisis
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public final class ParameterOutput {

	public ParameterOutput(int index, int dataType) {
		this.index = index;
		this.dataType = dataType;
	}

	public int getDataType() {
		return dataType;
	}

	public int getIndex() {
		return index;
	}

	public void setDataType(int i) {
		dataType = i;
	}

	public void setIndex(int i) {
		index = i;
	}

	private int index;

	private int dataType;

}
