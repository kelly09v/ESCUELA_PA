package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Testimonio;
import com.escuela_patinaje.escuela_patinaje.Services.TestimonioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {

    private final TestimonioService testimonioService;

    public TestimonioController(TestimonioService testimonioService) {
        this.testimonioService = testimonioService;
    }

    @GetMapping
    public String listarTestimonios(Model model) {
        model.addAttribute("testimonios", testimonioService.listarTodos());
        return "testimonios/lista";
    }

    @GetMapping("/nuevo")
    public String crearTestimonio(Model model) {
        model.addAttribute("testimonio", new Testimonio());
        return "testimonios/form";
    }

    @PostMapping
    public String guardarTestimonio(@ModelAttribute Testimonio testimonio) {
        testimonioService.guardar(testimonio);
        return "redirect:/testimonios";
    }

    @GetMapping("/editar/{id}")
    public String editarTestimonio(@PathVariable Long id, Model model) {
        Testimonio testimonio = testimonioService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Testimonio no encontrado"));
        model.addAttribute("testimonio", testimonio);
        return "testimonios/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTestimonio(@PathVariable Long id) {
        testimonioService.eliminar(id);
        return "redirect:/testimonios";
    }
}

