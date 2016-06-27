/**
 * @author Om Deshpande
 * 
 */
package com.omdeshpande.lib.abstracts;

import com.omdeshpande.lib.interfaces.BasicController;
import com.omdeshpande.lib.interfaces.Layout;

/**
 * @author Om Deshpande
 * 
 *
 */
public abstract class BasicBlogControllerAbstract implements BasicController {
	
	private String viewName;
	private Layout layout;
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public Layout getLayout() {
		return layout;
	}
	public void setLayout(Layout layout) {
		this.layout = layout;
	}
}
