package com.JobHub.Web.Controler;

import com.JobHub.Persistence.entity.Usuario;
import com.JobHub.Service.DTO.UsuarioDTO;
import com.JobHub.Service.PersonaService;
import com.JobHub.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Usuario")
public class UsuarioControler {

    private final UsuarioService usuarioService;
     @Autowired
    public UsuarioControler(UsuarioService usuarioService, PersonaService personaService) {
        this.usuarioService = usuarioService;
     }
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(this.usuarioService.getAll());
    }
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> get(@PathVariable int idUsuario){
        return ResponseEntity.ok(this.usuarioService.get(idUsuario));

    }
    @PostMapping
    public ResponseEntity<Usuario> add (@RequestBody Usuario usuario){
        if (usuario.getIdUsuario() == null || !this.usuarioService.exists(usuario.getIdUsuario()))  {
            return ResponseEntity.ok(this.usuarioService.save(usuario));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Usuario> update (@RequestBody Usuario usuario){
        if(usuario.getIdUsuario() != null && this.usuarioService.exists(usuario.getIdUsuario())) {
            return ResponseEntity.ok(this.usuarioService.save(usuario));
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody UsuarioDTO dto) {
         var respuesta = this.usuarioService.registrarUsuario(dto);
         if(respuesta != null){
             return ResponseEntity.ok(respuesta);
         }else {
             return ResponseEntity.badRequest().build();
         }
    }
}
