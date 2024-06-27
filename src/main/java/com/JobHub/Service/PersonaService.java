package com.JobHub.Service;

import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Persona;
import com.JobHub.Persistence.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAll() {
        return this.personaRepository.findAll();
    }
    public Persona get(int idPersona) {
        return this.personaRepository.findById(idPersona).orElse(null);
    }
    public Persona save(Persona Persona){
        return this.personaRepository.save(Persona);
    }
    public boolean exists(int idEmpleo){
        return this.personaRepository.existsById(idEmpleo);
    }
}
