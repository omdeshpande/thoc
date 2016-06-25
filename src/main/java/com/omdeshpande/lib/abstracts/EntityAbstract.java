/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import java.util.HashMap;

import com.omdeshpande.lib.interfaces.Entity;
import com.omdeshpande.lib.interfaces.EntityMeta;

/**
 * @author Om Deshpande
 *
 */
public abstract class EntityAbstract implements Entity {
	
	private EntityMeta type;
	
	public EntityAbstract(EntityMeta type) {
		this.setType(type);
	}

	public void setValue(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	public void setValues(HashMap<String, Object> values) {
		// TODO Auto-generated method stub
		
	}

	public Object getValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, Object> getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityMeta getType() {
		return type;
	}

	protected void setType(EntityMeta type) {
		this.type = type;
	}
	
}
