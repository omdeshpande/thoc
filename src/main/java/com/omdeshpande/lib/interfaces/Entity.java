/**
 * 
 */
package com.omdeshpande.lib.interfaces;

import java.util.List;

/**
 * @author Om Deshpande
 *
 */
public interface Entity {

	public void addAttribute(Attribute attribute);
	
	public List<Attribute> getAttributes();
	
	public void setAttributes(List<Attribute> attributes);
	
}
