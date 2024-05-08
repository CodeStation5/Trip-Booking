package com.webvacations.ecommerce.dao;

import com.webvacations.ecommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// cartItems is the name of the JSON entry
@RepositoryRestResource(collectionResourceRel = "cartItems", path = "cartItems")
@CrossOrigin(origins = "http://localhost:4200")
// CartItem is the entity, pk is Long
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
