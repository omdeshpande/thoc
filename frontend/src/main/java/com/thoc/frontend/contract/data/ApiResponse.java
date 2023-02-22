package com.thoc.frontend.contract.data;

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
	 * @return API response content of instance {@link String}.
	 */
	public String getContent();
	
	/**
	 * Set API response content.
	 * 
	 * @param content API content of instance {@link}.
	 * @return void
	 */
	public void setContent(String content);
}
