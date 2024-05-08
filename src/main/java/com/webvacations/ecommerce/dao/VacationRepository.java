package com.webvacations.ecommerce.dao;

import com.webvacations.ecommerce.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


// vacations is the name of the JSON entry
@RepositoryRestResource (collectionResourceRel = "vacations", path = "vacations")
@CrossOrigin(origins = "http://localhost:4200")
// Vacation is the entity, pk is Long
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
