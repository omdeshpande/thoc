package com.thoc.user.contract.data;

import org.springframework.security.core.userdetails.UserDetails;

public interface User extends UserDetails
{
    /**
     * Get user ID.
     * 
     * @return Returns the unique ID of the user of instance {@link Integer}.
     */
    public Integer getId();

    /**
     * Set unique ID for the user.
     * 
     * @param id Unique ID of the user of instance {@link Integer}.
     * @return void
     */
    public void setId(Integer id);

    /**
     * Get user's first name.
     * 
     * @return Returns the first name of the user of instance {@link String}.
     */
    public String getFirstName();

    /**
     * Set first name for the user.
     * 
     * @param firstName First name of the user of instance {@link String}.
     * @return void
     */
    public void setFirstName(String firstName);

    /**
     * Get user's last name.
     * 
     * @return Returns the last name of the user of instance {@link String}.
     */
    public String getLastName();

    /**
     * Set last name for the user.
     * 
     * @param lastName Last name of the user of instance {@link String}.
     * @return void
     */
    public void setLastName(String lastName);

    /**
     * Get user mobile.
     * 
     * @return Returns the user mobile of instance {@link String}.
     */
    public String getMobile();

    /**
     * Set mobile for the user.
     * 
     * @param mobile Mobile of the user of instance {@link String}.
     * @return void
     */
    public void setMobile(String mobile);

    /**
     * Set username for the user.
     * 
     * @param username Username of the user of instance {@link String}.
     * @return void
     */
    public void setUsername(String username);

    /**
     * Set password for the user.
     * 
     * @param password Password of the user of instance {@link String}.
     * @return void
     */
    public void setPassword(String password);
}
