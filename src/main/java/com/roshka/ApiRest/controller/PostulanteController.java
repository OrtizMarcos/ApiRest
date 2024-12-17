package com.roshka.ApiRest.controller;

import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.service.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteService postulanteService;

    @GetMapping
    public List<Postulante> getAllPostulantes() {
        return postulanteService.getAllPostulantes();
    }

    @GetMapping("/{id}")
    public Optional<Postulante> getPostulanteById(@PathVariable Long id) {
        return postulanteService.getPostulanteById(id);
    }

    @PostMapping
    public Postulante savePostulante(@RequestBody Postulante postulante) {
        return postulanteService.savePostulante(postulante);
    }

    @DeleteMapping("/{id}")
    public void deletePostulante(@PathVariable Long id) {
        postulanteService.deletePostulante(id);
    }

    @DeleteMapping("/cedula/{nroCedula}")
    public void eliminarPostulantePorCedula(@PathVariable String nroCedula) {
        postulanteService.eliminarPostulantePorCedula(nroCedula);
    }
}
