package com.escuela_patinaje.escuela_patinaje.Services;


import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Entities.Evento;
import com.escuela_patinaje.escuela_patinaje.Repository.EventoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public List<Evento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Evento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Evento guardar(Evento evento) {
        return repository.save(evento);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

