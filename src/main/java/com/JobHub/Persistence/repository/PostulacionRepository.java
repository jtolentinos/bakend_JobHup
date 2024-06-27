package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Postulacion;
import org.springframework.data.repository.ListCrudRepository;

public interface PostulacionRepository extends ListCrudRepository<Postulacion, Integer> {
}
