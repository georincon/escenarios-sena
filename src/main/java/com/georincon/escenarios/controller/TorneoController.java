package com.georincon.escenarios.controller;

import com.georincon.escenarios.model.Municipio;
import com.georincon.escenarios.model.Patrocinador;
import com.georincon.escenarios.model.Torneo;
import com.georincon.escenarios.repository.MunicipioRepository;
import com.georincon.escenarios.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TorneoController {

    @Autowired
    private TorneoRepository torneoRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @GetMapping("/torneos")
    public String listarTorneos(Model modelo) {
        List<Torneo> listaTorneos = torneoRepository.findAll();
        modelo.addAttribute("listaTorneos", listaTorneos);
        return "torneos";
    }

    @GetMapping("/torneo/nuevo")
    public String mostrarFormularioDeNuevoTorneo(Model modelo) {
        List<Municipio> listaMunicipios =  municipioRepository.findAll();
        modelo.addAttribute("torneo", new Torneo());
        modelo.addAttribute("listaMunicipios", listaMunicipios);

        return "torneo_formulario";
    }


    @GetMapping("/torneo/editar/{id}")
    public String mostrarFormularioDeModificarTorneo(@PathVariable("id") Integer id, Model modelo) {
        Torneo torneo = torneoRepository.findById(id).get();
        modelo.addAttribute("torneo", torneo);

        List<Municipio> listaMunicipios =  municipioRepository.findAll();
        modelo.addAttribute("listaMunicipios", listaMunicipios);

        return "torneo_formulario";
    }

    @PostMapping("/torneo/guardar")
    public String guardarTorneo(Torneo torneo) {
        torneoRepository.save(torneo);
        return "redirect:/torneos";
    }

    @GetMapping("/torneo/eliminar/{id}")
    public String eliminaTorneo(@PathVariable(value="id") Integer id) {
        this.torneoRepository.deleteById(id);
        return "redirect:/torneos";
    }


}
