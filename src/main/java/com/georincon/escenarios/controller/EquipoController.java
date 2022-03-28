package com.georincon.escenarios.controller;

import com.georincon.escenarios.model.Equipo;
import com.georincon.escenarios.model.Municipio;
import com.georincon.escenarios.model.Patrocinador;
import com.georincon.escenarios.model.Torneo;
import com.georincon.escenarios.repository.EquipoRepository;
import com.georincon.escenarios.repository.MunicipioRepository;
import com.georincon.escenarios.repository.PatrocinadorRepository;
import com.georincon.escenarios.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private PatrocinadorRepository patrocinadorRepository;

    @GetMapping("/equipos")
    public String listarEquipos(Model modelo) {
        List<Equipo> listaEquipos = equipoRepository.findAll();
        modelo.addAttribute("listaEquipos", listaEquipos);
        return "equipos";
    }

    @GetMapping("/equipo/nuevo")
    public String mostrarFormularioDeNuevoEquipo(Model modelo) {
        List<Patrocinador> listaPatrocinadores =  patrocinadorRepository.findAll();
        modelo.addAttribute("equipo", new Equipo());
        modelo.addAttribute("listaPatrocinadores", listaPatrocinadores);

        return "equipo_formulario";
    }


    @GetMapping("/equipo/editar/{id}")
    public String mostrarFormularioDeModificarEquipo(@PathVariable("id") Integer id, Model modelo) {
        Equipo equipo = equipoRepository.findById(id).get();
        modelo.addAttribute("equipo", equipo);

        List<Patrocinador> listaPatrocinadores =  patrocinadorRepository.findAll();
        modelo.addAttribute("listaPatrocinadores", listaPatrocinadores);

        return "equipo_formulario";
    }

    @PostMapping("/equipo/guardar")
    public String guardarEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
        return "redirect:/equipos";
    }

    @GetMapping("/equipo/eliminar/{id}")
    public String eliminaEquipo(@PathVariable(value="id") Integer id) {
        this.equipoRepository.deleteById(id);
        return "redirect:/equipos";
    }

}
