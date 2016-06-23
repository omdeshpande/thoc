/**
 * 
 */
package com.omdeshpande.lib.interfaces;

import java.util.HashMap;
import java.util.List;

/**
 * @author Om Deshpande
 *
 */
public interface Entity {

	public void setValue(String name, Object value);
	
	public void setValues(HashMap<String, Object> values);
	
	public Attribute getAttribute(String name);
	
	public List<Attribute> getAttributes();
	
}
