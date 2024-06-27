package com.JobHub.Service;

import com.JobHub.Persistence.entity.Persona;
import com.JobHub.Persistence.entity.Usuario;
import com.JobHub.Persistence.repository.PersonaRepository;
import com.JobHub.Persistence.repository.UsuarioRepository;
import com.JobHub.Service.DTO.UsuarioDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }
    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }
    public Usuario get(int idUsuario){
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }
    public Usuario save(Usuario Usuario){
        return this.usuarioRepository.save(Usuario);
    }
    public boolean exists(int idEmpleo){
        return this.usuarioRepository.existsById(idEmpleo);
    }
    public Usuario loguinUsua(String nombreUsua, String clave) {
        Usuario usuario = usuarioRepository.findByNombreUsuaAndClave(nombreUsua,clave);
        if (usuario != null) {
            return usuario;
        } else {
            throw new RuntimeException("Usuario o clave incorrectos");
        }
    }

    @Transactional
    public Usuario registrarUsuario(UsuarioDTO dto) {

        Usuario user = usuarioRepository.findByNombreUsuario(dto.getNombreUsua());
        if(user == null) {
            // Crear y guardar la entidad Persona
            Persona persona = new Persona();
            persona.setNombre(dto.getNombre());
            persona.setApellidoPaterno(dto.getApellidoPaterno());
            persona.setApellidoMaterno(dto.getApellidoMaterno());
            persona.setDNI(dto.getDni());
            persona.setFechaNacimiento(Date.valueOf(dto.getFechaNacimiento()));
            persona.setSexo(dto.getSexo());
            persona.setTelefono(dto.getTelefono());
            persona.setCorreo(dto.getCorreo());
            persona.setDireccion(dto.getDireccion());
            Persona nuevaPersona = personaRepository.save(persona);

            // Crear y guardar la entidad Usuario
            Usuario usuario = new Usuario();
            usuario.setIdPersona(nuevaPersona.getIdPersona());
            usuario.setEstado(true);
            usuario.setNombreUsua(dto.getNombreUsua());
            usuario.setClave(dto.getClaveUsua());
            LocalDateTime now = LocalDateTime.now();
            usuario.setFechaRegistro(now);
            usuario.setPersona(nuevaPersona);
            return usuarioRepository.save(usuario);

        }else {
            return null;
        }

    }

}
