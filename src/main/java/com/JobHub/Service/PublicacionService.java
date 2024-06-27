package com.JobHub.Service;


import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Publicacion;
import com.JobHub.Persistence.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionService {
    private final PublicacionRepository publicacionRepository;
    @Autowired
    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository=publicacionRepository;
    }

    public List<Publicacion> getAll() {
        return this.publicacionRepository.findAll();
    }
    public Publicacion get(int idPublicacion) {
        return this.publicacionRepository.findById(idPublicacion).orElse(null);
    }
    public Publicacion save(Publicacion Publicacion){
        return this.publicacionRepository.save(Publicacion);
    }
    public boolean exists(int idEmpleo){
        return this.publicacionRepository.existsById(idEmpleo);
    }
}
