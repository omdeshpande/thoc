package com.thoc.user.model.api;

import org.springframework.stereotype.Component;

import com.thoc.user.contract.api.ApiContent;

@Component
public class ApiResponse implements com.thoc.user.contract.api.ApiResponse
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
	private ApiContent content;

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
	public ApiContent getContent() 
	{
		return this.content;
	}

	@Override
	public void setContent(ApiContent content) 
	{
		this.content = content;	
	}
}
