package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Categoria;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoriaRepository extends ListCrudRepository<Categoria, Integer> {
}
