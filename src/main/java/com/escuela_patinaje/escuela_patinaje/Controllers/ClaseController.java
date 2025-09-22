package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Clase;
import com.escuela_patinaje.escuela_patinaje.Services.ClaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clases")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public String listarClases(Model model) {
        model.addAttribute("clases", claseService.listarTodos());
        return "clases/lista";
    }

    @GetMapping("/nueva")
    public String crearClase(Model model) {
        model.addAttribute("clase", new Clase());
        return "clases/form";
    }

    @PostMapping
    public String guardarClase(@ModelAttribute Clase clase) {
        claseService.guardar(clase);
        return "redirect:/clases";
    }

    @GetMapping("/editar/{id}")
    public String editarClase(@PathVariable Long id, Model model) {
        Clase clase = claseService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
        model.addAttribute("clase", clase);
        return "clases/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarClase(@PathVariable Long id) {
        claseService.eliminar(id);
        return "redirect:/clases";
    }
}

