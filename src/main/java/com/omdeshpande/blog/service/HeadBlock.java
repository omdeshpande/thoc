/**
 * 
 */
package com.omdeshpande.blog.service;

import java.util.ArrayList;
import java.util.List;

import com.omdeshpande.lib.abstracts.BlockAbstract;

/**
 * @author Om Deshpande
 *
 */
public class HeadBlock extends BlockAbstract {

	private ArrayList<String> css;
	private ArrayList<String> js;
	
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

	public List<?> getContent() {
		// TODO Auto-generated method stub
		return null;
	}
}
