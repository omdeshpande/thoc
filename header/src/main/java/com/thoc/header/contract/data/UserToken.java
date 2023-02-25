package com.thoc.header.contract.data;

import java.io.Serializable;

public interface UserToken extends Serializable
{

	/**
	 * Get the user token.
	 * 
	 * @return User token of instance {@link String}
	 */
	public String getId();
	
	/**
	 * Set the user token.
	 * 
	 * @param token User token of instance {@link String}
	 * @return void
	 */
	public void setId(String token);
	
	/**
	 * Get username.
	 * 
	 * @return Username of instance {@link String}
	 */
	public String getUsername();
	
	/**
	 * Set the username.
	 * 
	 * @param username Username of instance {@link String}
	 * @return void
	 */
	public void setUsername(String username);
	
	/**
	 * Get user id.
	 * 
	 * @return User ID of instance {@link Integer}
	 */
	public Integer getUserId();
	
	/**
	 * Set the user id.
	 * 
	 * @param userId User ID of instance {@link Integer}
	 * @return void
	 */
	public void setUserId(Integer userId);
}
