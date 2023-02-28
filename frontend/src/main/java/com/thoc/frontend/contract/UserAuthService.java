package com.thoc.frontend.contract;

import java.util.List;

import com.thoc.frontend.contract.data.ApiResponse;
import com.thoc.frontend.contract.data.UserToken;

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
	 * Logs the user out.
	 * 
	 * @param token Authorization token of instance {@link String}.
	 * @return void
	 */
	public UserAuthService logout(String token);
	
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
	
	/**
	 * Validates an authentication token.
	 * 
	 * @param token Authentication token of instance {@link String}.
	 * @return Whether a token is valid or not (true / false).
	 */
	public UserAuthService validateAuthToken(String token);
	
	/**
	 * Get the user details, post successful authentication.
	 * 
	 * @return User details of instance {@link UserToken}.
	 */
	public UserToken getUserDetails();
	
	/**
	 * Get the login form html from the user service.
	 * 
	 * @param token Auth token of instance {@link String}.
	 * @return Api response of instance {@link ApiResponse}.
	 */
	public ApiResponse getLoginForm(String token);
}
