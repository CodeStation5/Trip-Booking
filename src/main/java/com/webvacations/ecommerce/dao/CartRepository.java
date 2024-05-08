package com.webvacations.ecommerce.dao;

import com.webvacations.ecommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// carts is the name of the JSON entry
@RepositoryRestResource(collectionResourceRel = "carts", path = "carts")
@CrossOrigin(origins = "http://localhost:4200")
// Cart is the entity, pk is Long
public interface CartRepository extends JpaRepository<Cart, Long> {
}