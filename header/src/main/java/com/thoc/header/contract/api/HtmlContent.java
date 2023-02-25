package com.thoc.header.contract.api;

public interface HtmlContent extends ApiContent
{
	/**
	 * Get html content.
	 * 
	 * @return Html content of instance {@link String}.
	 */
	public String getHtml();
	
	/**
	 * Set html content.
	 * 
	 * @param html Html content of instance {@link String}.
	 * return void
	 */
	public void setHtml(String html);
}
