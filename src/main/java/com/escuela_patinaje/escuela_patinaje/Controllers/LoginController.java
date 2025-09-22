package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.escuela_patinaje.escuela_patinaje.Repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email,
                                @RequestParam String password,
                                Model model,
                                HttpSession session) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getPassword().equals(password)) {
            // Guardar en sesión
            session.setAttribute("usuarioLogueado", usuario);

            // Redirigir según el rol
            if ("ADMIN".equals(usuario.getRol())) {
                return "redirect:/admin/home";
            } else if ("ENTRENADOR".equals(usuario.getRol())) {
                return "redirect:/entrenador/home";
            } else if ("ALUMNO".equals(usuario.getRol())) {
                return "redirect:/alumno/home";
            }
        }

        model.addAttribute("error", "⚠️ Email o contraseña incorrectos");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
