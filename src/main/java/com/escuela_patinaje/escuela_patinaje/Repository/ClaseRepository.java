package com.escuela_patinaje.escuela_patinaje.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.escuela_patinaje.escuela_patinaje.Entities.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
}
