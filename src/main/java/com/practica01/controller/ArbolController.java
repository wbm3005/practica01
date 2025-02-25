package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/arboles")
@Slf4j
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;

    @GetMapping
    public String listarArboles(Model model) {
        List<Arbol> arboles = arbolService.findAll();
        model.addAttribute("arboles", arboles);
        return "arboles";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "formArbol"; 
    }

    @PostMapping("/guardar")
    public String guardarArbol(@ModelAttribute("arbol") Arbol arbol) {
        if (arbol.getNombre() == null || arbol.getEspecie() == null) {
            log.error("Intento de guardar un árbol con valores nulos.");
            return "redirect:/arboles";
        }
        arbolService.save(arbol);
        return "redirect:/arboles";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Optional<Arbol> arbol = Optional.ofNullable(arbolService.findById(id));
        arbol.ifPresent(value -> model.addAttribute("arbol", value));
        return arbol.isPresent() ? "formArbol" : "redirect:/arboles";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable("id") Long id) {
        arbolService.delete(id);
        return "redirect:/arboles";
    }
}
