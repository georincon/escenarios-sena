package com.georincon.escenarios.controller;

import com.georincon.escenarios.model.*;
import com.georincon.escenarios.repository.EquipoRepository;
import com.georincon.escenarios.repository.TorneoEquipoRepository;
import com.georincon.escenarios.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TorneoEquipoController {

    @Autowired
    private TorneoEquipoRepository torneoEquipoRepository;

    @Autowired
    private TorneoRepository torneoRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @GetMapping("/torneoequipo/nuevo")
    public String mostrarFormularioDeNuevoTorneoEquipo(Model modelo) {
        List<Torneo> listaTorneos =  torneoRepository.findAll();
        List<Equipo> listaEquipos =  equipoRepository.findAll();
        modelo.addAttribute("torneoequipo", new TorneoEquipo());
        modelo.addAttribute("listaTorneos", listaTorneos);
        modelo.addAttribute("listaEquipos", listaEquipos);

        return "torneoequipo_formulario";
    }

    @PostMapping("/torneoequipo/guardar")
    public String guardarTorneoEquipo(TorneoEquipo torneoequipo) {
        torneoEquipoRepository.save(torneoequipo);
        return "redirect:/torneoequipo";
    }

    @GetMapping("/torneoequipo")
    public String listarTorneoEquipo(Model modelo) {
        List<TorneoEquipo> listaTorneoEquipo = torneoEquipoRepository.findAll();
        modelo.addAttribute("listaTorneoEquipo", listaTorneoEquipo);
        return "torneoequipo";
    }

    @GetMapping("/torneoequipo/editar/{id}")
    public String mostrarFormularioDeEditarTorneoEquipo(@PathVariable(value="id") Integer id, Model modelo) {
        TorneoEquipo torneoequipo = torneoEquipoRepository.findById(id).get();
        modelo.addAttribute("torneoequipo", torneoequipo);

        List<Torneo> listaTorneos = torneoRepository.findAll();
        List<Equipo> listaEquipos = equipoRepository.findAll();
        modelo.addAttribute("listaTorneos", listaTorneos);
        modelo.addAttribute("listaEquipos", listaEquipos);

        return "torneoequipo_formulario";
    }

    @GetMapping("/torneoequipo/eliminar/{id}")
    public String eliminaTorneoEquipo(@PathVariable(value="id") Integer id) {
        this.torneoEquipoRepository.deleteById(id);
        return "redirect:/torneoequipo";
    }

}
