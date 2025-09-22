package com.escuela_patinaje.escuela_patinaje.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escuela_patinaje.escuela_patinaje.Entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}

