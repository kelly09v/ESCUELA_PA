package com.escuela_patinaje.escuela_patinaje.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;
    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    // Relación con Clase
    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;

    public enum EstadoPago {
        PENDIENTE, PAGADO, VENCIDO
    }
}
