/**
 * 
 */
package com.omdeshpande.lib.interfaces;

import java.util.Map;

/**
 * @author Om Deshpande
 *
 */
public interface LayoutService {

	public void prepareLayout();

	public Map<String, BlockService> getBlocks();
	
}
