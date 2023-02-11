package com.thoc.user.model;

import com.thoc.user.contract.data.*;
import com.thoc.user.database.entity.*;
import com.thoc.user.database.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.*;
import org.modelmapper.ModelMapper;

@Component
@Transactional
public class UserService implements com.thoc.user.contract.UserService
{

    /**
     * User Repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Model Mapper to convert entity to DTO and vice versa.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * User DTO.
     */
    @Autowired
    private User user;

    /**
     * User entity.
     */
    private UserEntity userEntity = new UserEntity();

    /**
     * User password.
     */
    private UserPassword userPassword = new UserPassword();

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user)
    {
        // Copy data to the entity object from the front-end DTO.
        this.userEntity = modelMapper.map(user, UserEntity.class);

        // If the user exists, copy the user ID, else .
        Optional<UserEntity> userEntityWrapper = this.userRepository.findByEmail(user.getUsername());
        userEntityWrapper.ifPresent((existingUser) -> this.userEntity.setId(existingUser.getId()));
        
        // Set the Password.
        Set<UserPassword> updatedUserPasswords = new HashSet<UserPassword>();
        if(this.userEntity.getUserPassword().isEmpty() != true) {
            Iterator<UserPassword> iterator = this.userEntity.getUserPassword().iterator();
            while(iterator.hasNext()) {
                UserPassword newPassword = iterator.next();
                if(newPassword.getIsActive()) {
                    newPassword.setPassword(user.getPassword());
                }
                updatedUserPasswords.add(newPassword);
            }
        } else {
            this.userPassword.setPassword(user.getPassword());
            this.userPassword.setUser(this.userEntity);
            updatedUserPasswords.add(this.userPassword);
        }
        this.userEntity.setUserPassword(updatedUserPasswords);

        // Set email.
        this.userEntity.setEmail(user.getUsername());

        // Save.
        this.userRepository.save(this.userEntity);
    }

    /**
     * Spring security implementation to authenticate users.
     * 
     * @param username Username / email of the user of instance {@link String}
     * @return User details of instance {@link UserDetails}
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<UserEntity> userEntityWrapper = this.userRepository.findByEmail(username);
        if(userEntityWrapper.isPresent()) {
            UserEntity userEntity = userEntityWrapper.get();
            this.user = modelMapper.map(userEntity, com.thoc.user.model.data.User.class);
            this.user.setUsername(userEntity.getEmail());
            for(UserPassword password : userEntity.getUserPassword()) {
                this.user.setPassword(
                    password.getPassword()
                );
            }
            return this.user;
        };
         
        throw new UsernameNotFoundException("User not found.");
    }
    
}
