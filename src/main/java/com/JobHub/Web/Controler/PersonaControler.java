package com.JobHub.Web.Controler;

import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Persona;
import com.JobHub.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Persona")
public class PersonaControler {
    private final PersonaService personaService;

    @Autowired
    public PersonaControler(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getAll(){
        return ResponseEntity.ok(this.personaService.getAll());
    }
    @GetMapping("/{idPersona}")
    public ResponseEntity<Persona> get(@PathVariable int idPersona){
        return ResponseEntity.ok(this.personaService.get(idPersona));
    }
    @PostMapping
    public ResponseEntity<Persona> add (@RequestBody Persona persona){
        if (persona.getIdPersona() == null || !this.personaService.exists(persona.getIdPersona())) {
            return ResponseEntity.ok(this.personaService.save(persona));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Persona> update (@RequestBody Persona persona) {
        if (persona.getIdPersona() != null && this.personaService.exists(persona.getIdPersona())) {
            return ResponseEntity.ok(this.personaService.save(persona));
        }
        return ResponseEntity.badRequest().build();
    }

}

