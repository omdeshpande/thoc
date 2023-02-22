package com.thoc.frontend.model.data;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse implements com.thoc.frontend.contract.data.ApiResponse
{
	/**
	 * API response status.
	 */
	private String status;
	
	/**
	 * API response description.
	 */
	private String description;
	
	/**
	 * API response content.
	 */
	private String content;

	@Override
	public String getStatus() 
	{
		return this.status;
	}

	@Override
	public void setStatus(String status) 
	{
		this.status = status;
	}

	@Override
	public String getDescription() 
	{
		return this.description;
	}

	@Override
	public void setDescription(String description) 
	{
		this.description = description;
	}

	@Override
	public String getContent() 
	{
		return this.content;
	}

	@Override
	public void setContent(String content) 
	{
		this.content = content;
	}
}
