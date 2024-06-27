package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Empleador;
import org.springframework.data.repository.ListCrudRepository;

public interface EmpleadorRepository extends ListCrudRepository<Empleador, Integer> {
}
