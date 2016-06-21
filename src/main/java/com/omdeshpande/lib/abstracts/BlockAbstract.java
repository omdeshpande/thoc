/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import com.omdeshpande.lib.interfaces.BlockService;

/**
 * @author Om Deshpande
 *
 */
public abstract class BlockAbstract implements BlockService {

	/**
	 * @author Om Deshpande
	 * Indicates the layout service under which this
	 * block is being rendered. Useful, because some blocks may
	 * choose to render different data for different layout handlers 
	 */
	private String handler;

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}
	
}
