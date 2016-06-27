/**
 * 
 */
package com.omdeshpande.frontend.content.dao;

import com.omdeshpande.lib.abstracts.HibernateDaoAbstract;
import com.omdeshpande.lib.interfaces.AttributeValue;

/**
 * @author Om Deshpande
 *
 */
public class AttributeValueIntDao extends HibernateDaoAbstract<AttributeValue, Integer> {

	public AttributeValueIntDao(Class<AttributeValue> type) {
		super(type);
	}

}
