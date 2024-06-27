package com.JobHub.Web.Controler;

import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Notificaciones;
import com.JobHub.Service.NotificacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Notificaciones")
public class NotificacionesControler {

    private final NotificacionesService notificacionesService;
    private final NotificacionesService NotificacionesRepository;

    public NotificacionesControler(NotificacionesService notificacionesService, NotificacionesService notificacionesRepository) {
        this.notificacionesService = notificacionesService;
        this.NotificacionesRepository = notificacionesRepository;
    }
    @GetMapping
    public ResponseEntity<List<Notificaciones>> getAll(){
        return ResponseEntity.ok(this.notificacionesService.getAll());
    }
    @GetMapping("/{idNotificacion}")
    public ResponseEntity<Notificaciones> get(@PathVariable int idNotificacion){
        return ResponseEntity.ok(this.NotificacionesRepository.get(idNotificacion));

    }
    @PostMapping
    public ResponseEntity<Notificaciones> add (@RequestBody Notificaciones notificaciones){
        if(notificaciones.getIdNotificacion() == null || !this.notificacionesService.exists(notificaciones.getIdNotificacion())) {
            return ResponseEntity.ok(this.notificacionesService.save(notificaciones));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Notificaciones> update (@RequestBody Notificaciones notificaciones){
        if(notificaciones.getIdNotificacion() != null && this.notificacionesService.exists(notificaciones.getIdNotificacion())) {
            return ResponseEntity.ok(this.notificacionesService.save(notificaciones));
        }
        return ResponseEntity.badRequest().build();
    }
}
