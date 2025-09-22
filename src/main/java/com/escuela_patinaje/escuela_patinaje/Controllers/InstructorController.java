package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Instructor;
import com.escuela_patinaje.escuela_patinaje.Services.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructores")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public String listarInstructores(Model model) {
        model.addAttribute("instructores", instructorService.listarTodos());
        return "instructores/lista";
    }

    @GetMapping("/nuevo")
    public String crearInstructor(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructores/form";
    }

    @PostMapping
    public String guardarInstructor(@ModelAttribute Instructor instructor) {
        instructorService.guardar(instructor);
        return "redirect:/instructores";
    }

    @GetMapping("/editar/{id}")
    public String editarInstructor(@PathVariable Long id, Model model) {
        Instructor instructor = instructorService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Instructor no encontrado"));
        model.addAttribute("instructor", instructor);
        return "instructores/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarInstructor(@PathVariable Long id) {
        instructorService.eliminar(id);
        return "redirect:/instructores";
    }
}
