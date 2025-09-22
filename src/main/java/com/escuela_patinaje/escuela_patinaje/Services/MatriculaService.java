package com.escuela_patinaje.escuela_patinaje.Services;


import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Entities.Matricula;
import com.escuela_patinaje.escuela_patinaje.Repository.MatriculaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;

    public MatriculaService(MatriculaRepository repository) {
        this.repository = repository;
    }

    public List<Matricula> listarTodos() {
        return repository.findAll();
    }

    public Optional<Matricula> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Matricula guardar(Matricula matricula) {
        return repository.save(matricula);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

