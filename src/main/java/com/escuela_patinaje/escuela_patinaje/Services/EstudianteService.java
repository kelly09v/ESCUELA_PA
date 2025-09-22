package com.escuela_patinaje.escuela_patinaje.Services;



import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Entities.Estudiante;
import com.escuela_patinaje.escuela_patinaje.Repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante>listarTodos() {
        return repository.findAll();
    }

    public Optional<Estudiante>buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public Estudiante eliminar(Long id, Estudiante estudiante) {
        return repository.findById(id)
                .map(e -> {
                    e.setNombre(estudiante.getNombre());
                    e.setApellido(estudiante.getApellido());
                    e.setTelefono(estudiante.getTelefono());
                    e.setDireccion(estudiante.getDireccion());
                    e.setEstado(estudiante.getEstado());
                    return repository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

