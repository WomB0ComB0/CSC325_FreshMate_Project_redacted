package org.csc325.freshmate_api.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.csc325.freshmate_api.model.Grocery;

/**
 * Entity class representing a user.
 */
@Table(name = "users")
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Grocery> groceries;

    /**
     * Returns the authorities granted to the user.
     *
     * @return a collection of granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username of the user.
     *
     * @return the email of the user
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Checks if the user's account is expired.
     *
     * @return true if the account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checks if the user's account is locked.
     *
     * @return true if the account is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Checks if the user's credentials are expired.
     *
     * @return true if the credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Checks if the user is enabled.
     *
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Gets the ID of the user.
     *
     * @return the ID of the user
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the ID to set
     * @return the current instance of User
     */
    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the full name of the user.
     *
     * @return the full name of the user
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the user.
     *
     * @param fullName the full name to set
     * @return the current instance of User
     */
    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to set
     * @return the current instance of User
     */
    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     * @return the current instance of User
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Gets the creation date of the user.
     *
     * @return the creation date of the user
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date of the user.
     *
     * @param createdAt the creation date to set
     * @return the current instance of User
     */
    public User setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Gets the last updated date of the user.
     *
     * @return the last updated date of the user
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated date of the user.
     *
     * @param updatedAt the last updated date to set
     * @return the current instance of User
     */
    public User setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Gets the list of groceries associated with the user.
     *
     * @return the list of groceries
     */
    public List<Grocery> getGroceries() {
        return groceries;
    }

    /**
     * Sets the list of groceries associated with the user.
     *
     * @param groceries the list of groceries to set
     * @return the current instance of User
     */
    public User setGroceries(List<Grocery> groceries) {
        this.groceries = groceries;
        return this;
    }

    /**
     * Returns a string representation of the User.
     *
     * @return a string representation of the User
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}