package com.thoc.user.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_password")
public class UserPassword
{
    /**
     * Auto increment for the password table.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    /**
     * Password of the user.
     */
    @Column(name = "password_hash")
    private String password;

    @Column(name = "is_active")
    private boolean isActive;

    /**
     * Joining with the user entity.
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey())
    private UserEntity userEntity;

    /**
     * Get increment ID of the password table.
     * 
     * @return Returns the increment of the password table of instance {@link Integer}.
     */
    public Integer getPid()
    {
        return this.pid;
    }

    /**
     * Set increment ID of the password table.
     * 
     * @param pid Increment ID of the password table of instance {@link Integer}
     * @return void
     */
    public void setPid(Integer pid)
    {
        this.pid = pid;
    }

    /**
     * Get password hash.
     * 
     * @return Returns the password hash of the user of instance {@link String}.
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * Set password hash for the user.
     * 
     * @param password Password hash of the user of instance {@link String}
     * @return void
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Is the password active.
     * 
     * @return Answers whether the password is active with an instance of {@link boolean}.
     */
    public boolean getIsActive()
    {
        return this.isActive;
    }

    /**
     * Set is active for the password.
     * 
     * @param isActive Is active value of instance {@link boolean}.
     * @return void
     */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * Get user.
     * 
     * @return Returns the user of instance {@link UserEntity}.
     */
    public UserEntity getUser()
    {
        return this.userEntity;
    }

    /**
     * Set user.
     * 
     * @param userEntity User of instance {@link UserEntity}
     * @return void
     */
    public void setUser(UserEntity userEntity)
    {
        this.userEntity = userEntity;
    }
}
