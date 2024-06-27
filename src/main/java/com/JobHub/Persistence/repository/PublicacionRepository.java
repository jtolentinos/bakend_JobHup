package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Publicacion;
import org.springframework.data.repository.ListCrudRepository;

public interface PublicacionRepository extends ListCrudRepository<Publicacion, Integer> {
}
