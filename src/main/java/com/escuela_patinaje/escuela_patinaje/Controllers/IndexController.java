package com.escuela_patinaje.escuela_patinaje.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/vision")
public String vision() {
    return "vision"; // nombre del archivo HTML de la visión
}


    @GetMapping("/mision")
    public String mision() {
        return "mision"; // esto busca el archivo mision.html en templates
    }
}



