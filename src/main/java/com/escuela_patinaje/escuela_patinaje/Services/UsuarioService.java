package com.escuela_patinaje.escuela_patinaje.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Entities.Usuario;
import com.escuela_patinaje.escuela_patinaje.Repository.UsuarioRepository;

@Service

public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;
    // private final PasswordEncoder passwordEncoder;

    // Constructor
    private UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos los usuarios de la base de datos
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar por id un usuario
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar un nuevo usuario
    public Usuario guardar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por id
    public void eliminar(Long id){
        usuarioRepository.deleteById(id);
    }

    // Buscar por nombre de usuario
    public Usuario buscarPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }
    
}
