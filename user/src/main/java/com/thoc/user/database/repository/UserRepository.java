package com.thoc.user.database.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.thoc.user.database.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>
{
    /**
     * Find a user by email.
     * 
     * @param email Email of the user of instance {@link String}
     * @return Returns a user object of instance {@link Optional} which contains the object {@link UserEntity}
     */
    public Optional<UserEntity> findByEmail(String email);
}
