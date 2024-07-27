package org.csc325.freshmate_api.service;

import org.csc325.freshmate_api.model.Grocery;
import org.csc325.freshmate_api.model.GroceryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for handling grocery-related operations.
 */
public interface GroceryService {

    /**
     * Retrieves a paginated list of groceries based on the provided filter and pageable information.
     *
     * @param filter the filter criteria for groceries
     * @param pageable the pagination information
     * @return a paginated list of groceries
     */
    Page<Grocery> getGroceryPage(GroceryFilter filter, Pageable pageable);

    /**
     * Retrieves a grocery by its ID.
     *
     * @param id the ID of the grocery
     * @return an Optional containing the grocery if found, or an empty Optional if not found
     */
    Optional<Grocery> getGrocery(UUID id);

    /**
     * Saves a grocery to the repository.
     *
     * @param grocery the grocery to save
     * @return the saved grocery
     */
    Grocery saveGrocery(Grocery grocery);

    /**
     * Deletes a grocery by its ID.
     *
     * @param id the ID of the grocery to delete
     */
    void deleteGrocery(UUID id);

    /**
     * Assigns a grocery to a user.
     *
     * @param groceryId the ID of the grocery to assign
     * @param userId the ID of the user to assign the grocery to
     * @return the updated grocery with the assigned user
     */
    Grocery assignGroceryToUser(UUID groceryId, Integer userId);
}