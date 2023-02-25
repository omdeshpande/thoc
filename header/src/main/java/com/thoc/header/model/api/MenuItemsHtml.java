package com.thoc.header.model.api;

import org.springframework.stereotype.Component;

import com.thoc.header.contract.api.HtmlContent;

@Component("MenuItemsHtml")
public class MenuItemsHtml implements HtmlContent
{
	
	/**
	 * Html content.
	 */
	private String html;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getHtml() 
	{
		return this.html;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setHtml(String html)
	{
		this.html = html;
	}
	
}
