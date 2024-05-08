package com.webvacations.ecommerce.dao;

import com.webvacations.ecommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// customers is the name of the JSON entry
@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
@CrossOrigin(origins = "http://localhost:4200")
// Customer is the entity, pk is Long
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}