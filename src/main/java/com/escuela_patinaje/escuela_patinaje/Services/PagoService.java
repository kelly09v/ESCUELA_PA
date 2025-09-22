package com.escuela_patinaje.escuela_patinaje.Services;

import com.escuela_patinaje.escuela_patinaje.Entities.Pago;
import com.escuela_patinaje.escuela_patinaje.Repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public List<Pago> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pago> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pago guardar(Pago pago) {
        return repository.save(pago);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

