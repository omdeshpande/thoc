/**
 * 
 */
package com.omdeshpande.lib.interfaces;

/**
 * @author Om Deshpande
 *
 */
public interface Attribute {
	
	public void setId(int id);
	
	public int getId();
		
	public void setEntity(EntityMeta entity);
	
	public EntityMeta getEntity();
	
	public void setName(String name);
	
	public String getName();
	
	public void setDescription(String description);
	
	public String getDescription();
	
	public void setDataType(AttributeDataType dataType);
	
	public AttributeDataType getDataType();
	
	public void setDisplayType(AttributeDisplayType dataType);
	
	public AttributeDisplayType getDisplayType();

}
