package com.JobHub.Web.Controler;

import com.JobHub.Persistence.entity.Categoria;
import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Usuario;
import com.JobHub.Persistence.repository.CategoriaRepository;
import com.JobHub.Persistence.repository.EmpleoRepository;
import com.JobHub.Service.EmpleoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Empleo")
public class EmpleaoControler {

    private final EmpleoService empleoService;
    private final EmpleoRepository empleoRepository;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public EmpleaoControler(EmpleoService empleoService, EmpleoRepository empleoRepository, CategoriaRepository categoriaRepository) {
        this.empleoService = empleoService;
        this.empleoRepository = empleoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    @GetMapping
    public ResponseEntity<List<Empleo>> getAll(){
        return ResponseEntity.ok(this.empleoService.getAllEmpleo());
    }
    @GetMapping("/{categoria}")
    public ResponseEntity<List<Categoria>> getAllCategoria(){
        return ResponseEntity.ok(this.empleoService.getAllCategoria());
    }
    @GetMapping("/{idEmpleo}")
    public ResponseEntity<Empleo> get(@PathVariable int idEmpleo){
        return ResponseEntity.ok(this.empleoService.get(idEmpleo));

    }
    @PostMapping
    public ResponseEntity<Empleo> add (@RequestBody Empleo empleo){
        if(empleo.getIdEmpleo() == null || !this.empleoService.exists(empleo.getIdEmpleo())) {
            return ResponseEntity.ok(this.empleoService.save(empleo));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Empleo> update (@RequestBody Empleo empleo){
        if(empleo.getIdEmpleo() != null && this.empleoService.exists(empleo.getIdEmpleo())) {
            return ResponseEntity.ok(this.empleoService.save(empleo));
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/buscar")
    public ResponseEntity<Empleo> BuscarEmpleo(@RequestParam Integer ciudad, @RequestParam Integer categoria) {
        try {
            Empleo empleo = this.empleoService.BuscarEmpleo(ciudad, categoria);
            return ResponseEntity.ok(empleo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).build();
        }
    }
}
