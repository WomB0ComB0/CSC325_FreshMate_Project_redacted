package org.csc325.freshmate_api.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.csc325.freshmate_api.model.Grocery;

import java.util.UUID;

/**
 * Repository interface for interacting with the database.
 */
@Repository
public interface GroceryRepository extends  ListCrudRepository<Grocery, UUID>, JpaSpecificationExecutor<Grocery> {
}
