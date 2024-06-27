package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Persona;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonaRepository extends ListCrudRepository<Persona, Integer> {
}
