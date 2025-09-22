package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Asistencia;
import com.escuela_patinaje.escuela_patinaje.Services.AsistenciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @GetMapping
    public String listarAsistencias(Model model) {
        model.addAttribute("asistencias", asistenciaService.listarTodos());
        return "asistencias/lista";
    }

    @GetMapping("/nuevo")
    public String crearAsistencia(Model model) {
        model.addAttribute("asistencia", new Asistencia());
        return "asistencias/form";
    }

    @PostMapping
    public String guardarAsistencia(@ModelAttribute Asistencia asistencia) {
        asistenciaService.guardar(asistencia);
        return "redirect:/asistencias";
    }

    @GetMapping("/editar/{id}")
    public String editarAsistencia(@PathVariable Long id, Model model) {
        Asistencia asistencia = asistenciaService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Asistencia no encontrada"));
        model.addAttribute("asistencia", asistencia);
        return "asistencias/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAsistencia(@PathVariable Long id) {
        asistenciaService.eliminar(id);
        return "redirect:/asistencias";
    }
}

