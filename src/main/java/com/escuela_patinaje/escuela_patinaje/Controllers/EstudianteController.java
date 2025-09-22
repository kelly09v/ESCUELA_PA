package com.escuela_patinaje.escuela_patinaje.Controllers;


import com.escuela_patinaje.escuela_patinaje.Entities.Estudiante;
import com.escuela_patinaje.escuela_patinaje.Services.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        return "estudiantes/lista";
    }

    @GetMapping("/nuevo")
    public String crearEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes/form";
    }

    @PostMapping
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.guardar(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));
        model.addAttribute("estudiante", estudiante);
        return "estudiantes/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return "redirect:/estudiantes";
    }
}

