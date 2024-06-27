package com.JobHub.Web.Controler;

import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Usuario;
import com.JobHub.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Loguin")
public class LoguinControler {

    private final UsuarioService usuarioService;

    @Autowired
    public LoguinControler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(this.usuarioService.getAll());
    }
     @PostMapping
     public ResponseEntity<Usuario> loguinUsua(@RequestParam String nombreUsua, @RequestParam String clave) {
     try {
         Usuario usuario = this.usuarioService.loguinUsua(nombreUsua, clave);
         return ResponseEntity.ok(usuario);
     } catch (RuntimeException e) {
         return ResponseEntity.status(401).build();
     }
 }

}
