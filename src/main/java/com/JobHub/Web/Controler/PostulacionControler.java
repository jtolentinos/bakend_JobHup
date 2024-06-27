package com.JobHub.Web.Controler;


import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Postulacion;
import com.JobHub.Service.PostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Postulacion")
public class PostulacionControler {

    private final PostulacionService postulacionService;
    @Autowired
    public PostulacionControler(PostulacionService postulacionService) {
        this.postulacionService = postulacionService;
    }
    @GetMapping
    public ResponseEntity<List<Postulacion>> getAll(){
        return ResponseEntity.ok(this.postulacionService.getAll());
    }
    @GetMapping("/{idPostulacion}")
    public ResponseEntity<Postulacion> getPostulacion(@PathVariable int idPostulacion){
        return ResponseEntity.ok(this.postulacionService.get(idPostulacion));
    }
    @PostMapping
    public ResponseEntity<Postulacion> add (@RequestBody Postulacion postulacion){
        if(postulacion.getIdPostulacion() == null || !this.postulacionService.exists(postulacion.getIdPostulacion())) {
            return ResponseEntity.ok(this.postulacionService.save(postulacion));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Postulacion> update (@RequestBody Postulacion postulacion){
        if(postulacion.getIdPostulacion() != null && this.postulacionService.exists(postulacion.getIdPostulacion())) {
            return ResponseEntity.ok(this.postulacionService.save(postulacion));
        }
        return ResponseEntity.badRequest().build();
    }
}
