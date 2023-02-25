package com.thoc.header.model.data;

import org.springframework.stereotype.Component;

@Component
public class UserToken implements com.thoc.header.contract.data.UserToken
{

	private static final long serialVersionUID = -6375031533828045056L;

	/**
	 * User token.
	 */
	public String id;
	
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
		return this.id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String token) 
	{
		this.id = token;
		
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
