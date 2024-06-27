package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Empresa;
import org.springframework.data.repository.ListCrudRepository;

public interface EmpresaRepository extends ListCrudRepository<Empresa, Integer> {
}
