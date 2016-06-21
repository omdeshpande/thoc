/**
 * 
 */
package com.omdeshpande.lib.interfaces;

import java.util.List;

/**
 * @author Om Deshpande
 *
 */
public interface BlockService {

	List<String> getCss();

	List<String> getJs();
	
	List<?> getContent();
}
