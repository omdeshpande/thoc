package com.thoc.user.database.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")
public class UserEntity
{
    /**
     * User ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(table = "user")
    private Integer id;

    /**
     * First Name.
     */
    @Column(table = "user")
    private String firstName;

    /**
     * Last Name.
     */
    @Column(table = "user")
    private String lastName;

    /**
     * Email, which acts as the unique username when logging in too.
     */
    @Column(table = "user")
    private String email;

    /**
     * Mobile.
     */
    @Column(table = "user")
    private String mobile;

    /**
     * Join with the user password entity.
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserPassword> userPassword = new HashSet<UserPassword>();

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
     * @param id Unique ID of the user of instance {@link Integer}
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
     * @param firstName First name of the user of instance {@link String}
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
     * @param lastName Last name of the user of instance {@link String}
     * @return void
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get user email.
     * 
     * @return Returns the user email of instance {@link String}.
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * Set email for the user.
     * 
     * @param email Email address of the user of instance {@link String}
     * @return void
     */
    public void setEmail(String email)
    {
        this.email = email;
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
     * @param mobile Mobile of the user of instance {@link String}
     * @return void
     */
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    /**
     * Get passwords.
     * 
     * @return Returns the password list of instance {@link Set<UserPassword>}.
     */
    public Set<UserPassword> getUserPassword()
    {
        return this.userPassword;
    }

    /**
     * Set passwords.
     * 
     * @param userPassword Password of the user of instance {@link Set<UserPassword>}
     * @return void
     */
    public void setUserPassword(Set<UserPassword> userPassword)
    {
        this.userPassword = userPassword;
    }
}
