package com.JobHub.Service;

import com.JobHub.Persistence.entity.Notificaciones;
import com.JobHub.Persistence.repository.NotificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionesService {
    private final NotificacionesRepository notificacionesRepository;

    @Autowired
    public NotificacionesService(NotificacionesRepository notificacionesRepository) {
        this.notificacionesRepository = notificacionesRepository;
    }
    public List<Notificaciones> getAll(){
        return this.notificacionesRepository.findAll();
    }
    public Notificaciones get(int idNotificacion) {
        return this.notificacionesRepository.findById(idNotificacion).orElse(null);
    }
    public Notificaciones save(Notificaciones notificaciones){
        return this.notificacionesRepository.save(notificaciones);
    }
    public boolean exists(int idNotificacion){
        return this.notificacionesRepository.existsById(idNotificacion);
    }
}
