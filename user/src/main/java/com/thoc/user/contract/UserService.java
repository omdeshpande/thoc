package com.thoc.user.contract;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.thoc.user.contract.data.User;

public interface UserService extends UserDetailsService
{

    /**
     * Create / update a user.
     * 
     * @param user User object of instance {@link User}.
     * @return Returns user object of instance {@link User}.
     */
    public void save(User user);
}
