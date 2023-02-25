package com.thoc.header.contract.data;

import java.util.Map;

public interface ApiResponse
{
	/**
	 * Get API response status.
	 * 
	 * @return API response status of instance {@link String}.
	 */
	public String getStatus();
	
	/**
	 * Set API response status.
	 * 
	 * @param status API status of instance {@link}.
	 * @return void
	 */
	public void setStatus(String status);
	
	/**
	 * Get API response description.
	 * 
	 * @return API response description of instance {@link String}.
	 */
	public String getDescription();
	
	/**
	 * Set API response description.
	 * 
	 * @param description API description of instance {@link}.
	 * @return void
	 */
	public void setDescription(String description);
	
	/**
	 * Get API response content.
	 * 
	 * @return API response content of instance {@link Map<String, Object>}.
	 */
	public Map<String, Object> getContent();
	
	/**
	 * Set API response content.
	 * 
	 * @param content API content of instance {@link Map<String, Object>}.
	 * @return void
	 */
	public void setContent(Map<String, Object> content);
}
