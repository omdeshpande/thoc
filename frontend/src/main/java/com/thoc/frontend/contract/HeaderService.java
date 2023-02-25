package com.thoc.frontend.contract;

import com.thoc.frontend.contract.data.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;

public interface HeaderService
{
	
	/**
	 * Gets the menu items from the header service.
	 * 
	 * @param request HTTP request object of instance {@link HttpServletRequest}
	 * @return API response of instance {@link ApiResponse}
	 */
	public ApiResponse getMenuItems(String token);
}
