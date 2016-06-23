/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import java.util.ArrayList;
import java.util.List;

import com.omdeshpande.lib.interfaces.Attribute;
import com.omdeshpande.lib.interfaces.EntityMeta;

/**
 * @author Om Deshpande
 *
 */
public abstract class EntityMetaAbstract implements EntityMeta {

	private List<Attribute> attributes;
	private String type;
	private String name;
	private String description;
	
	public EntityMetaAbstract() {
		attributes = new ArrayList<Attribute>();
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
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
	
}
