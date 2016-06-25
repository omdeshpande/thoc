package com.omdeshpande.frontend.content.model;

import com.omdeshpande.lib.abstracts.EntityMetaAbstract;
import com.omdeshpande.lib.interfaces.Attribute;

public class EntityMetaModel extends EntityMetaAbstract {

	private int id;
	private String title;
	private String description;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void save() {
		
	}

	public void addNewAttribute(Attribute attribute) {
		
	}
	
}
