/**
 * 
 */
package com.omdeshpande.frontend.content.dao;

import com.omdeshpande.lib.abstracts.HibernateDaoAbstract;
import com.omdeshpande.lib.interfaces.AttributeDisplayType;

/**
 * @author Om Deshpande
 *
 */
public class AttributeDisplayTypeDao extends HibernateDaoAbstract<AttributeDisplayType, Integer> {

	public AttributeDisplayTypeDao(Class<AttributeDisplayType> type) {
		super(type);
	}

}
