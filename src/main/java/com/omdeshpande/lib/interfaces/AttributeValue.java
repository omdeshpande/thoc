/**
 * 
 */
package com.omdeshpande.lib.interfaces;

/**
 * @author Om Deshpande
 *
 */
public interface AttributeValue {

	public int getId();
	
	public void setId(int id);
	
	public Entity getEntity();
	
	public void setEntity(Entity entity);
	
	public Object getValue();
	
	public void setValue(Object value);
	
	public Attribute getAttribute();
	
	public void setAttribute(Attribute attribute);

	
}
