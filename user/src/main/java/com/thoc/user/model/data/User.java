package com.thoc.user.model.data;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class User implements com.thoc.user.contract.data.User
{
    
	private static final long serialVersionUID = 6081524515717405200L;

	/**
     * User ID.
     */
    private Integer id;

    /**
     * First Name.
     */
    private String firstName;

    /**
     * Last Name.
     */
    private String lastName;

    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * Mobile.
     */
    private String mobile;

    /**
     * Get user ID.
     * 
     * @return Returns the unique ID of the user of instance {@link Integer}.
     */
    public Integer getId()
    {
        return this.id;
    }

    /**
     * Set unique ID for the user.
     * 
     * @param id Unique ID of the user of instance {@link Integer}.
     * @return void
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * Get user's first name.
     * 
     * @return Returns the first name of the user of instance {@link String}.
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Set first name for the user.
     * 
     * @param firstName First name of the user of instance {@link String}.
     * @return void
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Get user's last name.
     * 
     * @return Returns the last name of the user of instance {@link String}.
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Set last name for the user.
     * 
     * @param lastName Last name of the user of instance {@link String}.
     * @return void
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get user mobile.
     * 
     * @return Returns the user mobile of instance {@link String}.
     */
    public String getMobile()
    {
        return this.mobile;
    }

    /**
     * Set mobile for the user.
     * 
     * @param mobile Mobile of the user of instance {@link String}.
     * @return void
     */
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    /**
     * Authorities for the user.
     * 
     * @return Returns a {@link Collection} of instance {@link GrantedAuthority}.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    /**
     * Get username.
     * 
     * @return Username of the user of instance {@link String}.
     */
    @Override
    public String getUsername()
    {
        return this.username;
    }

    /**
     * 
     * @param username Username of the user of instance {@link String}.
     * @return void
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Get password of the user.
     * 
     * @return Password of the user of instance {@link String}.
     */
    @Override
    public String getPassword() 
    {
        return this.password;
    }

    /**
     * Set the user's password.
     * 
     * @param password User's password of instance {@link String}.
     * @return void
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
