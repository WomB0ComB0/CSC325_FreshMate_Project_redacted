package org.csc325.freshmate_api.implementations;

import lombok.RequiredArgsConstructor;
import org.csc325.freshmate_api.model.Grocery;
import org.csc325.freshmate_api.model.GroceryFilter;
import org.csc325.freshmate_api.repository.GroceryRepository;
import org.csc325.freshmate_api.repository.UserRepository;
import org.csc325.freshmate_api.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.csc325.freshmate_api.service.GroceryService;

import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of the GroceryService interface.
 */
@Service
@RequiredArgsConstructor
public class GroceryServiceImpl implements GroceryService {

    private final GroceryRepository groceryRepository;
    private final UserRepository userRepository;

    /**
     * Retrieves a paginated list of groceries based on the provided filter and pageable information.
     *
     * @param filter the filter criteria for groceries
     * @param pageable the pagination information
     * @return a paginated list of groceries
     */
    @Override
    public Page<Grocery> getGroceryPage(GroceryFilter filter, Pageable pageable) {
        Specification<Grocery> specification = filter.toSpecification();
        return groceryRepository.findAll(specification, pageable);
    }

    /**
     * Retrieves a grocery by its ID.
     *
     * @param id the ID of the grocery
     * @return an Optional containing the grocery if found, or an empty Optional if not found
     */
    @Override
    public Optional<Grocery> getGrocery(UUID id) {
        return groceryRepository.findById(id);
    }

    /**
     * Saves a grocery to the repository.
     *
     * @param grocery the grocery to save
     * @return the saved grocery
     */
    @Override
    public Grocery saveGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    /**
     * Deletes a grocery by its ID.
     *
     * @param id the ID of the grocery to delete
     */
    @Override
    public void deleteGrocery(UUID id) {
        groceryRepository.deleteById(id);
    }

    /**
     * Assigns a grocery to a user.
     *
     * @param groceryId the ID of the grocery to assign
     * @param userId the ID of the user to assign the grocery to
     * @return the updated grocery with the assigned user
     */
    @Override
    public Grocery assignGroceryToUser(UUID groceryId, Integer userId) {
        Grocery grocery = groceryRepository.findById(groceryId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        grocery.setUser(user);
        return groceryRepository.save(grocery);
    }
}