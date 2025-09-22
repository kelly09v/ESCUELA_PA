package com.escuela_patinaje.escuela_patinaje.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 20)
    private String rol; // Ej: "ADMIN", "INSTRUCTOR", "ESTUDIANTE"

     @Column(nullable = false, unique = true, length = 100)
    private String email; // ✅ Nuevo campo

     @Column(nullable = false, length = 20)
    private String telefono; // Teléfono del usuario


    // FK
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = true)
    private Estudiante estudiante_id;

    // Getters y Setters
    public Estudiante getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Estudiante estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
        }

    public String getEmail() {  // ✅ getter
        return email;
    }

    public void setEmail(String email) {  // ✅ setter
        this.email = email;
    }

     public String getTelefono() {  // ✅ getter
        return telefono;
    }

    public void setTelefono(String telefono) {  // ✅ setter
        this.telefono = telefono;
    }
}
