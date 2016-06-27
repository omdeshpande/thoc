/**
 * 
 */
package com.omdeshpande.frontend.content.dao;

import com.omdeshpande.frontend.content.model.EntityModel;
import com.omdeshpande.lib.abstracts.HibernateDaoAbstract;

/**
 * @author Om Deshpande
 * @param <T>
 * @param <PK>
 *
 */
public class EntityDao extends HibernateDaoAbstract<EntityModel, Integer> {

	public EntityDao(Class<EntityModel> type) {
		super(type);
	}

}
