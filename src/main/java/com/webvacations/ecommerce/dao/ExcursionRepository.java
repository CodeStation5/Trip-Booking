package com.webvacations.ecommerce.dao;

import com.webvacations.ecommerce.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


// excursions is the name of the JSON entry
@RepositoryRestResource(collectionResourceRel = "excursions", path = "excursions")
@CrossOrigin(origins = "http://localhost:4200")
// Excursion is the entity, pk is Long
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}