/**
 * 
 */
package com.omdeshpande.frontend.content.model;

import com.omdeshpande.lib.interfaces.Entity;
import com.omdeshpande.lib.interfaces.EntityMeta;

/**
 * @author Om Deshpande
 *
 */
public class EntityModel implements Entity {
	
	private int id;
	private EntityMeta meta;

	public EntityMeta getMeta() {
		return meta;
	}

	public void setMeta(EntityMeta meta) {
		this.meta = meta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
