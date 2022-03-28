package com.georincon.escenarios.controller;

import com.georincon.escenarios.model.Municipio;
import com.georincon.escenarios.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MunicipioController {

    @Autowired
    private MunicipioRepository municipioRepository;



    @GetMapping("/municipio/nuevo")
    public String mostrarFormularioDeNuevoMunicipio(Model modelo) {
        modelo.addAttribute("municipio", new Municipio());
        return "municipio_formulario";
    }

    @PostMapping("/municipio/guardar")
    public String guardarMunicipio(Municipio municipio) {
        municipioRepository.save(municipio);
        return "redirect:/municipios";
    }

    @GetMapping("/municipios")
    public String listarMunicipios(Model modelo) {
        List<Municipio> listaMunicipios = municipioRepository.findAll();
        modelo.addAttribute("listaMunicipios", listaMunicipios);
        return "municipios";
    }

    @GetMapping("/municipio/editar/{id}")
    public String mostrarFormularioDeEditarMunicipio(@PathVariable(value="id") Integer id, Model modelo) {
        Municipio municipio = municipioRepository.findById(id).get();
        modelo.addAttribute("municipio", municipio);
        return "municipio_formulario";
    }

    @GetMapping("/municipio/eliminar/{id}")
    public String eliminarMunicipio(@PathVariable(value="id") Integer id) {
        this.municipioRepository.deleteById(id);
        return "redirect:/municipios";
    }
}
