package com.thoc.user.model.data;

import org.springframework.stereotype.Component;

@Component
public class UserToken implements com.thoc.user.contract.data.UserToken
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
	 * {@inheritDoc}
	 */
	@Override
	public String getId() 
	{
		return this.Id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String token) 
	{
		this.Id = token;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUsername() 
	{
		return this.username;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUsername(String username) 
	{
		this.username = username;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getUserId() 
	{
		return this.userId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}
	
}
