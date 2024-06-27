package com.JobHub.Persistence.repository;

import com.JobHub.Persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends ListCrudRepository<Usuario, Integer> {
    @Query("SELECT c FROM Usuario c WHERE c.NombreUsua = :usuario AND c.Clave = :clave")
    Usuario findByNombreUsuaAndClave(@Param("usuario") String NombreUsua, @Param("clave") String Clave);

    @Query("SELECT c FROM Usuario c WHERE c.NombreUsua = :usuario")
    Usuario findByNombreUsuario(@Param("usuario") String NombreUsua);
}
