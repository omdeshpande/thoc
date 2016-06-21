/**
 * 
 */
package com.omdeshpande.blog.model;

/**
 * @author Om Deshpande
 *
 */
public class Menu {

	private String title;
	private String link;
	private Boolean active;
	private int rank;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
