package com.escuela_patinaje.escuela_patinaje.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.escuela_patinaje.escuela_patinaje.Entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}

