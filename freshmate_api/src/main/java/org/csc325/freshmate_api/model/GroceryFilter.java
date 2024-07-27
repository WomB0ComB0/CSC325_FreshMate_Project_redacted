package org.csc325.freshmate_api.model;

import jakarta.persistence.criteria.Predicate;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Filter class for querying groceries based on various criteria.
 */
@Value
@Builder(toBuilder = true)
public class GroceryFilter {
    String id;
    String userUuid;
    LocalDateTime createdAt;

    /**
     * Converts the filter criteria into a JPA Specification for querying the database.
     *
     * @return a Specification object for querying groceries
     */
    public Specification<Grocery> toSpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotEmpty(id)) {
                predicates.add(criteriaBuilder.equal(root.get("id"), UUID.fromString(id)));
            }
            if (StringUtils.isNotEmpty(userUuid)) {
                predicates.add(criteriaBuilder.equal(root.get("userUuid"), userUuid));
            }
            if (createdAt != null) {
                predicates.add(criteriaBuilder.equal(root.get("createdAt"), createdAt));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}