package com.webvacations.ecommerce.dao;

import com.webvacations.ecommerce.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// countries is the name of the JSON entry
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
@CrossOrigin(origins = "http://localhost:4200")
// Country is the entity, pk is Long
public interface CountryRepository extends JpaRepository<Country, Long> {
}
