package com.thoc.frontend.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserAuthService implements com.thoc.frontend.contract.UserAuthService
{
	/**
	 * Rest client.
	 */
	@Autowired
	private WebClient restClient;
	
	/**
	 * Response object.
	 */
	private ResponseEntity<com.thoc.frontend.model.data.ApiResponse> response;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserAuthService login(String username, String password)
	{
		this.response = this.restClient.post()
			.uri("http://localhost:8080/login")
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
		    .accept(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromFormData("username", username)
				.with("password", password))
			.retrieve()
			.toEntity(com.thoc.frontend.model.data.ApiResponse.class)
			.block();
		
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSuccess() 
	{
		if (this.response != null && this.response.getBody().getStatus().equals("200")) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getAuthToken() 
	{
		return this.response.getHeaders().get("Authorization");
	}
	
}
