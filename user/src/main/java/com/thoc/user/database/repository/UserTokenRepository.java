package com.thoc.user.database.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.thoc.user.database.entity.UserToken;

public interface UserTokenRepository extends CrudRepository<UserToken, String>
{

	/**
	 * Find user token details by username.
	 * 
	 * @param username Username of instance {@link String}.
	 * @return User token details of instance {@link Optional<UserToken>}
	 */
	Optional<UserToken> findByUsername(String username);
	
}
