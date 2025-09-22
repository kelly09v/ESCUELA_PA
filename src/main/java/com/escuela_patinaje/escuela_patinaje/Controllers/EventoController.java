package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Evento;
import com.escuela_patinaje.escuela_patinaje.Services.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventoService.listarTodos());
        return "eventos/lista";
    }

    @GetMapping("/nuevo")
    public String crearEvento(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/form";
    }

    @PostMapping
    public String guardarEvento(@ModelAttribute Evento evento) {
        eventoService.guardar(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/editar/{id}")
    public String editarEvento(@PathVariable Long id, Model model) {
        Evento evento = eventoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));
        model.addAttribute("evento", evento);
        return "eventos/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoService.eliminar(id);
        return "redirect:/eventos";
    }
}

