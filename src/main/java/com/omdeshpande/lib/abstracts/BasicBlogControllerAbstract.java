/**
 * @author Om Deshpande
 * 
 */
package com.omdeshpande.lib.abstracts;

import com.omdeshpande.lib.interfaces.BasicController;
import com.omdeshpande.lib.interfaces.LayoutService;

/**
 * @author Om Deshpande
 * 
 *
 */
public abstract class BasicBlogControllerAbstract implements BasicController {
	
	private String viewName;
	private LayoutService layout;
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public LayoutService getLayout() {
		return layout;
	}
	public void setLayout(LayoutService layout) {
		this.layout = layout;
	}
}
