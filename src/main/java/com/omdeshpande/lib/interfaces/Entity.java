/**
 * 
 */
package com.omdeshpande.lib.interfaces;

import java.util.HashMap;

/**
 * @author Om Deshpande
 *
 */
public interface Entity {

	public void setValue(String name, Object value);
	
	public void setValues(HashMap<String, Object> values);
	
	public Object getValue(String name);
	
	public HashMap<String, Object> getValues();
	
}
