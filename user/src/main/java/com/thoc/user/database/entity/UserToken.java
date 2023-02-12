package com.thoc.user.database.entity;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("UserToken")
public class UserToken implements Serializable
{

	/**
	 * User token.
	 */
	public String Id;
	
	/**
	 * Username.
	 */
	public String username;
	
	/**
	 * User id.
	 */
	public Integer userId;
	
	/**
	 * Get the user token.
	 * 
	 * @return User token of instance {@link String}
	 */
	public String getId()
	{
		return this.Id;
	}
	
	/**
	 * Set the user token.
	 * 
	 * @param token User token of instance {@link String}
	 * @return void
	 */
	public void setId(String token)
	{
		this.Id = token;
	}
	
	/**
	 * Get username.
	 * 
	 * @return Username of instance {@link String}
	 */
	public String getUsername()
	{
		return this.username;
	}
	
	/**
	 * Set the username.
	 * 
	 * @param username Username of instance {@link String}
	 * @return void
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * Get user id.
	 * 
	 * @return User ID of instance {@link Integer}
	 */
	public Integer getUserId()
	{
		return this.userId;
	}
	
	/**
	 * Set the user id.
	 * 
	 * @param userId User ID of instance {@link Integer}
	 * @return void
	 */
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	
}
