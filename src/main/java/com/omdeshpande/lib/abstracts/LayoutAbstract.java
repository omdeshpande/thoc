/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import java.util.Map;

import com.omdeshpande.lib.interfaces.BlockService;
import com.omdeshpande.lib.interfaces.LayoutService;

/**
 * @author Om Deshpande
 *
 */
public abstract class LayoutAbstract implements LayoutService {
	
	private Map<String, BlockService> blocks;

	public Map<String, BlockService> getBlocks() {
		return blocks;
	}

	public void setBlocks(Map<String, BlockService> blocks) {
		this.blocks = blocks;
	}
	
}
