package com.thoc.frontend.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.thoc.frontend.contract.data.ApiResponse;

@Service
public class UserAccountService implements com.thoc.frontend.contract.UserAccountService
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
	public ApiResponse getRegistrationForm(String token) 
	{
		return this.restClient.get()
			.uri("http://user-service/api/v1/html/registration-form")
			.header("Authorization", token)
		    .accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.toEntity(com.thoc.frontend.model.data.ApiResponse.class)
			.block()
			.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.thoc.frontend.contract.UserAccountService register(Map<String, String> fields) 
	{
		this.response = this.restClient.post()
			.uri("http://user-service/api/v1/user/create")
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
		    .accept(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromFormData("firstName", fields.get("firstName"))
				.with("lastName", fields.get("lastName"))
				.with("username", fields.get("username"))
				.with("password", fields.get("password"))
				.with("mobile", fields.get("mobile")))
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
		if (this.response.getBody() != null && this.response.getBody().getStatus().equals("200")) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApiResponse getUserEditForm(String token) 
	{
		return this.restClient.get()
			.uri("http://user-service/api/v1/html/user-edit-form")
			.header("Authorization", token)
		    .accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.toEntity(com.thoc.frontend.model.data.ApiResponse.class)
			.block()
			.getBody();
	}
	
}
