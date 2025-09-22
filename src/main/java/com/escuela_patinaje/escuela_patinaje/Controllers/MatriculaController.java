package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Matricula;
import com.escuela_patinaje.escuela_patinaje.Services.MatriculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public String listarMatriculas(Model model) {
        model.addAttribute("matriculas", matriculaService.listarTodos());
        return "matriculas/lista";
    }

    @GetMapping("/nuevo")
    public String crearMatricula(Model model) {
        model.addAttribute("matricula", new Matricula());
        return "matriculas/form";
    }

    @PostMapping
    public String guardarMatricula(@ModelAttribute Matricula matricula) {
        matriculaService.guardar(matricula);
        return "redirect:/matriculas";
    }

    @GetMapping("/editar/{id}")
    public String editarMatricula(@PathVariable Long id, Model model) {
        Matricula matricula = matriculaService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Matrícula no encontrada"));
        model.addAttribute("matricula", matricula);
        return "matriculas/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMatricula(@PathVariable Long id) {
        matriculaService.eliminar(id);
        return "redirect:/matriculas";
    }
}

