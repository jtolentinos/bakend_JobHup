package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Empleado;
import org.springframework.data.repository.ListCrudRepository;

public interface EmpleadoRepository extends ListCrudRepository<Empleado, Integer> {
}
