/**
 * 
 */
package com.omdeshpande.lib.interfaces;

/**
 * @author Om Deshpande
 *
 */
public interface Entity {

	public void setId(int id);
	
	public int getId();
	
	public void setMeta(EntityMeta meta);
	
	public EntityMeta getMeta();
	
}
