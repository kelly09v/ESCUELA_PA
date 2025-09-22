package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Nivel;
import com.escuela_patinaje.escuela_patinaje.Services.NivelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/niveles")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping
    public String listarNiveles(Model model) {
        model.addAttribute("niveles", nivelService.listarTodos());
        return "niveles/lista";
    }

    @GetMapping("/nuevo")
    public String crearNivel(Model model) {
        model.addAttribute("nivel", new Nivel());
        return "niveles/form";
    }

    @PostMapping
    public String guardarNivel(@ModelAttribute Nivel nivel) {
        nivelService.guardar(nivel);
        return "redirect:/niveles";
    }

    @GetMapping("/editar/{id}")
    public String editarNivel(@PathVariable Long id, Model model) {
        Nivel nivel = nivelService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Nivel no encontrado"));
        model.addAttribute("nivel", nivel);
        return "niveles/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNivel(@PathVariable Long id) {
        nivelService.eliminar(id);
        return "redirect:/niveles";
    }
}

