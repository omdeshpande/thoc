package com.thoc.frontend.contract;

import java.util.Map;

import com.thoc.frontend.contract.data.ApiResponse;

public interface UserAccountService
{
	/**
	 * Get registration form html from the user service.
	 * 
	 * @param token Auth token of instance {@link String}.
	 * @return Api response data of instance {@link ApiResponse}.
	 */
	public ApiResponse getRegistrationForm(String token);
	
	/**
	 * Calls the user service to register a new user.
	 * 
	 * @param fields Form fields of instance {@link Map<String, String>}
	 * @return Returns instance {@link UserAccountService}.
	 */
	public UserAccountService register(Map<String, String> fields);
	
	/**
	 * Whether the response was successful or not.
	 * 
	 * @return {@link boolean}.
	 */
	public boolean isSuccess();

	/**
	 * Get user edit form html from the user service.
	 * 
	 * @param token Auth token of instance {@link String}.
	 * @return Api response data of instance {@link ApiResponse}.
	 */
	public ApiResponse getUserEditForm(String token);
	
}
