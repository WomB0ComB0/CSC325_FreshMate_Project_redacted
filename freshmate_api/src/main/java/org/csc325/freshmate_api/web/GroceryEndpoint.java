package org.csc325.freshmate_api.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.csc325.freshmate_api.model.Grocery;
import org.csc325.freshmate_api.model.GroceryFilter;
import org.csc325.freshmate_api.service.GroceryService;
import org.csc325.freshmate_api.repository.UserRepository;
import org.csc325.freshmate_api.entities.User;

import java.util.UUID;

/**
 * REST controller for handling grocery-related requests.
 */
@RestController
@RequestMapping("/groceries")
@RequiredArgsConstructor
public class GroceryEndpoint {

    private final GroceryService groceryService;
    private final UserRepository userRepository;

    /**
     * Retrieves a paginated list of groceries based on the provided filter and pageable information.
     *
     * @param filter the filter criteria for groceries
     * @param pageable the pagination information
     * @return a paginated list of groceries
     */
    @GetMapping
    public Page<Grocery> getGroceries(GroceryFilter filter, Pageable pageable) {
        return groceryService.getGroceryPage(filter, pageable);
    }

    /**
     * Retrieves a grocery by its ID.
     *
     * @param id the ID of the grocery
     * @return a ResponseEntity containing the grocery if found, or a 404 status if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Grocery> getGrocery(@PathVariable UUID id) {
        return ResponseEntity.of(groceryService.getGrocery(id));
    }

    /**
     * Creates a new grocery and assigns it to a user.
     *
     * @param grocery the grocery to create
     * @param userId the ID of the user to assign the grocery to
     * @return a ResponseEntity containing the created grocery with a 201 status
     */
    @PostMapping
    public ResponseEntity<Grocery> createGrocery(@RequestBody Grocery grocery, @RequestParam Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        grocery.setUser(user);
        Grocery saved = groceryService.saveGrocery(grocery);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Updates an existing grocery by its ID.
     *
     * @param id the ID of the grocery to update
     * @param grocery the updated grocery data
     * @return a ResponseEntity containing the updated grocery if found, or a 404 status if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Grocery> updateGrocery(@PathVariable UUID id, @RequestBody Grocery grocery) {
        return groceryService.getGrocery(id).map(g -> {
                    grocery.setId(id);
                    return ResponseEntity.ok(groceryService.saveGrocery(grocery));
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a grocery by its ID.
     *
     * @param id the ID of the grocery to delete
     * @return a ResponseEntity with a 200 status if the grocery was deleted, or a 404 status if not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrocery(@PathVariable UUID id) {
        return groceryService.getGrocery(id).map(g -> {
                    groceryService.deleteGrocery(id);
                    return ResponseEntity.ok().build();
                }
        ).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Assigns a grocery to a user.
     *
     * @param groceryId the ID of the grocery to assign
     * @param userId the ID of the user to assign the grocery to
     * @return a ResponseEntity containing the updated grocery with the assigned user
     */
    @PostMapping("/{groceryId}/assign/{userId}")
    public ResponseEntity<Grocery> assignGroceryToUser(@PathVariable UUID groceryId, @PathVariable Integer userId) {
        Grocery assignedGrocery = groceryService.assignGroceryToUser(groceryId, userId);
        return ResponseEntity.ok(assignedGrocery);
    }
}