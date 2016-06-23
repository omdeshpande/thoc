/**
 * 
 */
package com.omdeshpande.lib.interfaces;

import java.util.List;

/**
 * @author Om Deshpande
 *
 */
public interface EntityMeta {
	
	public void setName(String name);
	
	public String getName();
	
	public void setDescription(String description);
	
	public String getDescription();
	
	public void setAttributes(List<Attribute> attributes);
	
	public List<Attribute> getAttributes();
	
	public void addNewAttribute(Attribute attribute);
	
}
