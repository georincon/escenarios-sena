package com.georincon.escenarios.controller;

import com.georincon.escenarios.model.Patrocinador;
import com.georincon.escenarios.repository.PatrocinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatrocinadorController {

    @Autowired
    private PatrocinadorRepository patrocinadorRepository;

    @GetMapping("/patrocinador/nuevo")
    public String mostrarFormularioDeNuevoPatrocinador(Model modelo) {
        modelo.addAttribute("patrocinador", new Patrocinador());
        return "patrocinador_formulario";
    }

    @PostMapping("/patrocinador/guardar")
    public String guardarPatrocinador(Patrocinador patrocinador) {
        patrocinadorRepository.save(patrocinador);
        return "redirect:/patrocinadores";
    }

    @GetMapping("/patrocinadores")
    public String listarPatrocinadores(Model modelo) {
        List<Patrocinador> listaPatrocinadores = patrocinadorRepository.findAll();
        modelo.addAttribute("listaPatrocinadores", listaPatrocinadores);
        return "patrocinadores";
    }

    @GetMapping("/patrocinador/editar/{id}")
    public String mostrarFormularioDeEditarPatrocinador(@PathVariable(value="id") Integer id, Model modelo) {
        Patrocinador patrocinador = patrocinadorRepository.findById(id).get();
        modelo.addAttribute("patrocinador", patrocinador);
        return "patrocinador_formulario";
    }

    @GetMapping("/patrocinador/eliminar/{id}")
    public String eliminarPatrocinador(@PathVariable(value="id") Integer id) {
        this.patrocinadorRepository.deleteById(id);
        return "redirect:/patrocinadores";
    }
}
