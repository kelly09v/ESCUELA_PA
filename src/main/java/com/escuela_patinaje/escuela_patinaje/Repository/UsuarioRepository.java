package com.escuela_patinaje.escuela_patinaje.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.escuela_patinaje.escuela_patinaje.Entities.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Se crean todos los metodos del CRUD (Personalizados) y adicionales requeridos
    Usuario findByNombre(String nombre);
    Usuario findByEmail(String email);
   
}


