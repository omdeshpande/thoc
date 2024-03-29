package com.thoc.user.contract;

import java.util.Optional;

import com.thoc.user.contract.data.UserToken;

public interface UserTokenService
{
	/**
	 * Generates a random user token to be used for authentication.
	 * 
	 * @return Returns a token of instance {@link String}
	 */
	public String generateToken();
	
	/**
	 * Save the token to persistent storage.
	 * 
	 * @param userToken User token of instance {@link UserToken}
	 * @return void
	 */
	public void saveToken(UserToken userToken);
	
	/**
	 * Validates a token and returns user details.
	 * 
	 * @param token Token of instance {@link String}
	 * @return An instance of {@link Optional<UserToken>}
	 */
	public Optional<UserToken> authenticateToken(String token);
	
	/**
	 * Find user token details by username.
	 * 
	 * @param username Username of instance {@link String}
	 * @return An instance of {@link Optional<UserToken>}
	 */
	public Optional<UserToken> findByUsername(String username);
	
	
	/**
	 * Delete user token.
	 * 
	 * @param userToken User token details of instance {@link UserToken}.
	 * @return void
	 */
	public void delete(UserToken userToken);
}
