package com.thoc.user.database.repository;

import org.springframework.data.repository.CrudRepository;
import com.thoc.user.database.entity.UserToken;

public interface UserTokenRepository extends CrudRepository<UserToken, String>
{
	
}
