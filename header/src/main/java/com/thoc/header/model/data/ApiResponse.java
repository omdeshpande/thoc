package com.thoc.header.model.data;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse implements com.thoc.header.contract.data.ApiResponse
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
	private Map<String, Object> content = new LinkedHashMap<>();

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
	public Map<String, Object> getContent() 
	{
		return this.content;
	}

	@Override
	public void setContent(Map<String, Object> content) 
	{
		this.content = content;
	}
}
