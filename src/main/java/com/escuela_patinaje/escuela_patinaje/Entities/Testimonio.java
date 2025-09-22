package com.escuela_patinaje.escuela_patinaje.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Testimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private String nombreAutor;
    private Boolean publicado;
}

