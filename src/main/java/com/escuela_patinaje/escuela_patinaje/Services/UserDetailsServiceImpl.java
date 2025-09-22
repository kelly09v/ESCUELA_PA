package com.escuela_patinaje.escuela_patinaje.Services;

import org.springframework.stereotype.Service;
import com.escuela_patinaje.escuela_patinaje.Repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl {

    private final UsuarioRepository usuarioRepository;


    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
}
