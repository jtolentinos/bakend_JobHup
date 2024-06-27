package com.JobHub.Service;

import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Postulacion;
import com.JobHub.Persistence.repository.PostulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulacionService {
    private final PostulacionRepository postulacionRepository;
    @Autowired
    public PostulacionService( PostulacionRepository postulacionRepository) {
        this.postulacionRepository=postulacionRepository;
    }
    public List<Postulacion> getAll() {
        return this.postulacionRepository.findAll();
    }
    public Postulacion get(int idPostulacion) {
        return this.postulacionRepository.findById(idPostulacion).orElse(null);
    }
    public Postulacion save(Postulacion Postulacion){
        return this.postulacionRepository.save(Postulacion);
    }
    public boolean exists(int idEmpleo){
        return this.postulacionRepository.existsById(idEmpleo);
    }
}
