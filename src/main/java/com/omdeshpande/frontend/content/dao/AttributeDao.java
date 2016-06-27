/**
 * 
 */
package com.omdeshpande.frontend.content.dao;

import com.omdeshpande.lib.abstracts.HibernateDaoAbstract;
import com.omdeshpande.lib.interfaces.Attribute;

/**
 * @author Om Deshpande
 *
 */
public class AttributeDao extends HibernateDaoAbstract<Attribute, Integer> {

	public AttributeDao(Class<Attribute> type) {
		super(type);
	}

}
