package com.escuela_patinaje.escuela_patinaje.Services;

import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Entities.Asistencia;
import com.escuela_patinaje.escuela_patinaje.Repository.AsistenciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    private final AsistenciaRepository repository;

    public AsistenciaService(AsistenciaRepository repository) {
        this.repository = repository;
    }

    public List<Asistencia> listarTodos() {
        return repository.findAll();
    }

    public Optional<Asistencia> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Asistencia guardar(Asistencia asistencia) {
        return repository.save(asistencia);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

