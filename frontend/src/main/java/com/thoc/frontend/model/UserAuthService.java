package com.thoc.frontend.model;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.thoc.frontend.contract.data.UserToken;
import com.thoc.frontend.model.data.ApiResponse;

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
	private ResponseEntity<ApiResponse> response;
	
	/**
	 * Model converter.
	 */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.thoc.frontend.contract.UserAuthService login(String username, String password)
	{
		this.response = this.restClient.post()
			.uri("http://localhost:8080/login")
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
		    .accept(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromFormData("username", username)
				.with("password", password))
			.retrieve()
			.toEntity(ApiResponse.class)
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
	public List<String> getAuthToken() 
	{
		return this.response.getHeaders().get("Authorization");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.thoc.frontend.contract.UserAuthService validateAuthToken(String token) 
	{
		this.response = this.restClient.get()
			.uri("http://localhost:8080/api/v1/user/token/validate")
			.header("Authorization", token)
		    .accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.toEntity(ApiResponse.class)
			.block();
		
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserToken getUserDetails()
	{
		Map<String, Object> content = this.response.getBody().getContent();
		return this.modelMapper.map(content, com.thoc.frontend.model.data.UserToken.class);
	}
}
