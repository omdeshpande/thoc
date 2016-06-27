/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import com.omdeshpande.lib.interfaces.Attribute;
import com.omdeshpande.lib.interfaces.AttributeValue;
import com.omdeshpande.lib.interfaces.Entity;

/**
 * @author Om Deshpande
 *
 */
public abstract class AttributeValueAbstract implements AttributeValue {
	
	private int id;
	private Entity entity;
	private Object value;
	private Attribute attribute;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Attribute getAttribute() {
		return attribute;
	}
	
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

}
