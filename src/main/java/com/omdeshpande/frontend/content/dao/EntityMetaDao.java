/**
 * 
 */
package com.omdeshpande.frontend.content.dao;

import com.omdeshpande.lib.abstracts.HibernateDaoAbstract;
import com.omdeshpande.lib.interfaces.EntityMeta;

/**
 * @author Om Deshpande
 *
 */
public class EntityMetaDao extends HibernateDaoAbstract<EntityMeta, Integer> {

	public EntityMetaDao(Class<EntityMeta> type) {
		super(type);
	}

}
