package org.csc325.freshmate_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.csc325.freshmate_api.entities.User;

/**
 * Entity class representing a grocery list.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ElementCollection
    @CollectionTable(name = "grocery_items", joinColumns = @JoinColumn(name = "grocery_id"))
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Gets the ID of the grocery list.
     *
     * @return the ID of the grocery list
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the ID of the grocery list.
     *
     * @param id the ID to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the list of items in the grocery list.
     *
     * @return the list of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the list of items in the grocery list.
     *
     * @param items the list of items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Gets the user associated with the grocery list.
     *
     * @return the user associated with the grocery list
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the grocery list.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the creation date and time of the grocery list.
     *
     * @return the creation date and time
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date and time of the grocery list.
     *
     * @param createdAt the creation date and time to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last updated date and time of the grocery list.
     *
     * @return the last updated date and time
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last updated date and time of the grocery list.
     *
     * @param updatedAt the last updated date and time to set
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}