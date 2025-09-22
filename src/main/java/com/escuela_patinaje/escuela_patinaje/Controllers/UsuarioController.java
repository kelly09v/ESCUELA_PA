package com.escuela_patinaje.escuela_patinaje.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.escuela_patinaje.escuela_patinaje.Entities.Usuario;
import com.escuela_patinaje.escuela_patinaje.Repository.UsuarioRepository;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // 📋 Listar todos los usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/lista"; // 👈 aquí debe estar tu vista de lista (list.html)
    }

    // ➕ Mostrar formulario de nuevo usuario
    @GetMapping("/form")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form"; // 👈 tu form.html
    }

    // ✏️ Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
        model.addAttribute("usuario", usuario);
        return "usuarios/nuevo"; // reutiliza el mismo formulario
    }

    @PostMapping
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
    usuarioRepository.save(usuario);
    return "redirect:/usuarios";
}


    // ❌ Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}

