package com.escuela_patinaje.escuela_patinaje.Services;


import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Entities.Clase;
import com.escuela_patinaje.escuela_patinaje.Repository.ClaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    private final ClaseRepository repository;

    public ClaseService(ClaseRepository repository) {
        this.repository = repository;
    }

    public List<Clase> listarTodos() {
        return repository.findAll();
    }

    public Optional<Clase> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Clase guardar(Clase clase) {
        return repository.save(clase);
    }

    public Clase eliminar(Long id, Clase clase) {
        return repository.findById(id)
                .map(c -> {
                    c.setNombre(clase.getNombre());
                    c.setHorario(clase.getHorario());
                    c.setDuracionMinutos(clase.getDuracionMinutos());
                    c.setInstructor(clase.getInstructor());
                    c.setNivel(clase.getNivel());
                    return repository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

