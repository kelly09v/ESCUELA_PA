package com.escuela_patinaje.escuela_patinaje.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.escuela_patinaje.escuela_patinaje.Entities.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}

