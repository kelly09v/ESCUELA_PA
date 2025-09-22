package com.escuela_patinaje.escuela_patinaje.Controllers;

import com.escuela_patinaje.escuela_patinaje.Entities.Pago;
import com.escuela_patinaje.escuela_patinaje.Services.PagoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public String listarPagos(Model model) {
        model.addAttribute("pagos", pagoService.listarTodos());
        return "pagos/lista"; // Vista: src/main/resources/templates/pagos/lista.html
    }

    @GetMapping("/nuevo")
    public String crearPago(Model model) {
        model.addAttribute("pago", new Pago());
        return "pagos/form"; // Vista: src/main/resources/templates/pagos/form.html
    }

    @PostMapping
    public String guardarPago(@ModelAttribute Pago pago) {
        pagoService.guardar(pago);
        return "redirect:/pagos";
    }

    @GetMapping("/editar/{id}")
    public String editarPago(@PathVariable Long id, Model model) {
        Pago pago = pagoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pago no encontrado"));
        model.addAttribute("pago", pago);
        return "pagos/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPago(@PathVariable Long id) {
        pagoService.eliminar(id);
        return "redirect:/pagos";
    }
}


