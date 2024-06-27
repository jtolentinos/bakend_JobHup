package com.JobHub.Service;

import com.JobHub.Persistence.entity.Categoria;
import com.JobHub.Persistence.entity.Empleo;
import com.JobHub.Persistence.entity.Usuario;
import com.JobHub.Persistence.repository.CategoriaRepository;
import com.JobHub.Persistence.repository.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleoService {
    private final EmpleoRepository empleoRepository;
    private final CategoriaRepository categoriaRepository;
    @Autowired
    public EmpleoService(EmpleoRepository empleoRepository, CategoriaRepository categoriaRepository) {
        this.empleoRepository = empleoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    public List<Empleo> getAllEmpleo() {
        return this.empleoRepository.findAll();
    }
    public Empleo get(int idEmpleo) {
        return this.empleoRepository.findById(idEmpleo).orElse(null);
    }

    public Empleo save(Empleo Empleo){
        return this.empleoRepository.save(Empleo);
    }
    public boolean exists(int idEmpleo){
        return this.empleoRepository.existsById(idEmpleo);
    }
    public List<Categoria> getAllCategoria() {
        return this.categoriaRepository.findAll();
    }

    public Empleo BuscarEmpleo(Integer categoria, Integer ciudad) {
        Empleo empleo = empleoRepository.findByCategoriaandCiudad(categoria,ciudad);
        if (empleo != null) {
            return empleo;
        } else {
            throw new RuntimeException("ciudad incorrecta");
        }
    }
}
