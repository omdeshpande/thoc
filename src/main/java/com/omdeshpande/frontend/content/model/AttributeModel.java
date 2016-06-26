/**
 * 
 */
package com.omdeshpande.frontend.content.model;

import com.omdeshpande.lib.interfaces.Attribute;
import com.omdeshpande.lib.interfaces.AttributeDataType;
import com.omdeshpande.lib.interfaces.AttributeDisplayType;
import com.omdeshpande.lib.interfaces.EntityMeta;

/**
 * @author Om Deshpande
 *
 */
public class AttributeModel implements Attribute {

	private int id;
	private EntityMeta entity;
	private String name;
	private String description;
	private AttributeDataType dataType;
	private AttributeDisplayType displayType;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public EntityMeta getEntity() {
		return entity;
	}
	
	public void setEntity(EntityMeta entity) {
		this.entity = entity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public AttributeDataType getDataType() {
		return dataType;
	}
	
	public void setDataType(AttributeDataType dataType) {
		this.dataType = dataType;
	}
	
	public AttributeDisplayType getDisplayType() {
		return displayType;
	}
	
	public void setDisplayType(AttributeDisplayType displayType) {
		this.displayType = displayType;
	}
	
}
