package com.JobHub.Web.Controler;
import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Publicacion;
import com.JobHub.Service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Publicacion")
public class PublicacionControler {

    private final PublicacionService publicacionService;

    @Autowired
    public PublicacionControler(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping
    public ResponseEntity<List<Publicacion>> getAll(){
        return ResponseEntity.ok(this.publicacionService.getAll());
    }
    @GetMapping("/{idPublicacion}")
    public ResponseEntity <Publicacion> get(int idPublicacion){
        return ResponseEntity.ok(this.publicacionService.get(idPublicacion));
    }
    @PostMapping
    public ResponseEntity<Publicacion> add (@RequestBody Publicacion publicacion){
        if (publicacion.getIdPublicacion() == null || !this.publicacionService.exists(publicacion.getIdPublicacion()))  {
            return ResponseEntity.ok(this.publicacionService.save(publicacion));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Publicacion> update (@RequestBody Publicacion publicacion){
        if(publicacion.getIdPublicacion() != null && this.publicacionService.exists(publicacion.getIdPublicacion())) {
            return ResponseEntity.ok(this.publicacionService.save(publicacion));
        }
        return ResponseEntity.badRequest().build();
    }
}
