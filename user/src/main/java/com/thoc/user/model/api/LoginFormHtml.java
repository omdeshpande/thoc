package com.thoc.user.model.api;

import org.springframework.stereotype.Component;

import com.thoc.user.contract.api.HtmlContent;

@Component
public class LoginFormHtml implements HtmlContent
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
