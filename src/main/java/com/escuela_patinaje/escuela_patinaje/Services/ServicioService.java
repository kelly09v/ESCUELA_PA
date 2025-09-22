package com.escuela_patinaje.escuela_patinaje.Services;


import org.springframework.stereotype.Service;

import com.escuela_patinaje.escuela_patinaje.Entities.Servicio;
import com.escuela_patinaje.escuela_patinaje.Repository.ServicioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }

    public List<Servicio> listarTodos() {
        return repository.findAll();
    }

    public Optional<Servicio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Servicio guardar(Servicio servicio) {
        return repository.save(servicio);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

