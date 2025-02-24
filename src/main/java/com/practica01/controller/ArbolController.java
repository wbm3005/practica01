package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ArbolController {
    
    @Autowired
    private ArbolService arbolService;
    
    @GetMapping("/arboles")
    public String listArboles(Model model) {
        model.addAttribute("arboles", arbolService.findAll());
        return "arboles";
    }
    
    // Mostrar formulario para crear un nuevo árbol
    @GetMapping("/nuevo")
    public String crearArbol(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "formArbol"; // Vista Thymeleaf para el formulario (formArbol.html)
    }

    // Guardar un árbol (creación o actualización)
    @PostMapping("/guardar")
    public String guardarArbol(@ModelAttribute("arbol") Arbol arbol) {
        arbolService.save(arbol);
        return "redirect:/arboles";
    }

    // Mostrar formulario para editar un árbol existente
    @GetMapping("/editar/{id}")
    public String editarArbol(@PathVariable("id") Long id, Model model) {
        Arbol arbol = arbolService.findById(id);
        model.addAttribute("arbol", arbol);
        return "formArbol"; // Reutiliza la misma vista para crear/editar
    }

    // Eliminar un árbol
    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable("id") Long id) {
        arbolService.delete(id);
        return "redirect:/arboles";
    }
}
