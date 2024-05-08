package com.webvacations.ecommerce.dao;

import com.webvacations.ecommerce.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// divisions is the name of the JSON entry
@RepositoryRestResource(collectionResourceRel = "divisions", path = "divisions")
@CrossOrigin(origins = "http://localhost:4200")
// Division is the entity, pk is Long
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
