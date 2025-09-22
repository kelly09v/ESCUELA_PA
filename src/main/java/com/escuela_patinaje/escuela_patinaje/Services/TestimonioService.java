package com.escuela_patinaje.escuela_patinaje.Services;


import com.escuela_patinaje.escuela_patinaje.Entities.Testimonio;
import com.escuela_patinaje.escuela_patinaje.Repository.TestimonioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestimonioService {

    private final TestimonioRepository repository;

    public TestimonioService(TestimonioRepository repository) {
        this.repository = repository;
    }

    public List<Testimonio>listarTodos() {
        return repository.findAll();
    }

    public Optional<Testimonio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Testimonio guardar(Testimonio testimonio) {
        return repository.save(testimonio);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

