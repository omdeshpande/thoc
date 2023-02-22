package com.thoc.frontend.contract;

import java.util.List;

public interface UserAuthService
{
	/**
	 * Login using username / password.
	 * 
	 * @param username Username of instance {@link String}.
	 * @param password Password of instance {@link String}.
	 * @return Object of instance {@link UserService}.
	 */
	public UserAuthService login(String username, String password);
	
	/**
	 * Whether the login was successful or not.
	 * 
	 * @return {@link boolean}.
	 */
	public boolean isSuccess();
	
	/**
	 * Get the authentication token for a successful login.
	 * 
	 * @return Authentication token of instance {@link String}.
	 */
	public List<String> getAuthToken();
}
