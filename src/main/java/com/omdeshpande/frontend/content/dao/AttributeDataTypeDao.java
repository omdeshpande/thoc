/**
 * 
 */
package com.omdeshpande.frontend.content.dao;

import com.omdeshpande.lib.abstracts.HibernateDaoAbstract;
import com.omdeshpande.lib.interfaces.AttributeDataType;

/**
 * @author Om Deshpande
 *
 */
public class AttributeDataTypeDao extends HibernateDaoAbstract<AttributeDataType, Integer> {

	public AttributeDataTypeDao(Class<AttributeDataType> type) {
		super(type);
	}

}
