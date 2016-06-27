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
public class AttributeValueVarcharDao extends HibernateDaoAbstract<AttributeValue, Integer> {

	public AttributeValueVarcharDao(Class<AttributeValue> type) {
		super(type);
	}

}
