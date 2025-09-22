package com.escuela_patinaje.escuela_patinaje.Services;



import org.springframework.stereotype.Service;

import com.escuela_patinaje.escuela_patinaje.Entities.Instructor;
import com.escuela_patinaje.escuela_patinaje.Repository.InstructorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // Listar todos
    public List<Instructor> listarTodos() {
        return instructorRepository.findAll();
    }

    // Guardar
    public Instructor guardar(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Buscar por ID
    public Optional<Instructor> buscarPorId(Long id) {
        return instructorRepository.findById(id);
    }

    // Eliminar
    public void eliminar(Long id) {
        instructorRepository.deleteById(id);
    }
}


