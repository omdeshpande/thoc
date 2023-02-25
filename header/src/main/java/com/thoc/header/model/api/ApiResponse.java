package com.thoc.header.model.api;

import org.springframework.stereotype.Component;

import com.thoc.header.contract.api.ApiContent;

@Component("api/response")
public class ApiResponse implements com.thoc.header.contract.api.ApiResponse
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
