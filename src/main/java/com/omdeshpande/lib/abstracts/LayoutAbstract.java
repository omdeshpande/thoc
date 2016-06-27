/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import java.util.Map;

import com.omdeshpande.lib.interfaces.Block;
import com.omdeshpande.lib.interfaces.Layout;

/**
 * @author Om Deshpande
 *
 */
public abstract class LayoutAbstract implements Layout {
	
	private Map<String, Block> blocks;

	public Map<String, Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(Map<String, Block> blocks) {
		this.blocks = blocks;
	}
	
}
