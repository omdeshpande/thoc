package com.thoc.frontend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.thoc.frontend.model.data.ApiResponse;

@Service
public class HeaderService implements com.thoc.frontend.contract.HeaderService
{
	
	/**
	 * Rest client.
	 */
	@Autowired
	private WebClient restClient;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.thoc.frontend.contract.data.ApiResponse getMenuItems(String token) 
	{
		ResponseEntity<ApiResponse> response = this.restClient.get()
			.uri("http://header-service/api/v1/html/menu-items")
			.header("Authorization", token)
		    .accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.toEntity(ApiResponse.class)
			.block();
		return response.getBody();
	}
	
}
