package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleoRepository extends ListCrudRepository<Empleo,Integer> {
    @Query("SELECT e FROM Empleo e WHERE e.idCategoria = :categoria AND e.idCiudad = :ciudad")
    Empleo findByCategoriaandCiudad(@Param("categoria") Integer idCategoria, @Param("ciudad") Integer idCiudad);

}
