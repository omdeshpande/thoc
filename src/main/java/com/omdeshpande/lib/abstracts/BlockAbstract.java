/**
 * 
 */
package com.omdeshpande.lib.abstracts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.omdeshpande.lib.interfaces.Block;
import com.omdeshpande.lib.interfaces.Dao;

/**
 * @author Om Deshpande
 *
 */
public abstract class BlockAbstract implements Block {

	/**
	 * @author Om Deshpande
	 * Indicates the layout service under which this
	 * block is being rendered. Useful, because some blocks may
	 * choose to render different data for different layout handlers 
	 */
	private String handler;
	
	/**
	 * @author Om Deshpande
	 * Provides the capability to add any custom JS / CSS required for
	 * the block while rendering. 
	 */
	private ArrayList<String> css;
	private ArrayList<String> js;
	
	/**
	 * @author Om Deshpande
	 * HashMap of the DOA required for the block (if required) need to be 
	 * injected via XML to be used here
	 */
	private HashMap<String, Dao<?, ?>> dao;
	
	public HashMap<String, Dao<?, ?>> getDao() {
		return dao;
	}

	public void setDao(HashMap<String, Dao<?, ?>> dao) {
		this.dao = dao;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}
	
	public List<String> getCss() {
		return css;
	}

	public void setCss(ArrayList<String> css) {
		this.css = css;
	}

	public List<String> getJs() {
		return js;
	}

	public void setJs(ArrayList<String> js) {
		this.js = js;
	}
	
}
