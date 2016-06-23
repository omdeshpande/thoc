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

	public void setAttribute(String name, Object value);
	
	public void setAttributes(HashMap<String, Object> values);
	
	public Attribute getAttribute(String name);
	
	public List<Attribute> getAttributes();
	
}
