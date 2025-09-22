package com.escuela_patinaje.escuela_patinaje.Services;



import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Entities.Nivel;
import com.escuela_patinaje.escuela_patinaje.Repository.NivelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NivelService {

    private final NivelRepository repository;

    public NivelService(NivelRepository repository) {
        this.repository = repository;
    }

    public List<Nivel> listarTodos() {
        return repository.findAll();
    }

    public Optional<Nivel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Nivel guardar(Nivel nivel) {
        return repository.save(nivel);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

