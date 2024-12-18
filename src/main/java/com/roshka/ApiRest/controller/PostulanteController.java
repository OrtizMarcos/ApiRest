package com.roshka.ApiRest.controller;

import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.service.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteService service;

    @GetMapping
    public ResponseEntity<List<Postulante>> getAllPostulantes() {
        return ResponseEntity.ok(service.getAllPostulantes());
    }

    @GetMapping("/cedula/{nroCedula}")
    public ResponseEntity<List<Postulante>> getPostulantesByNroCedula(@PathVariable Integer nroCedula) {
        return ResponseEntity.ok(service.getPostulantesByNroCedula(nroCedula));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Postulante> updatePostulante(
            @PathVariable Long id,
            @RequestBody Postulante updatedPostulante) {
        return ResponseEntity.ok(service.updatePostulante(id, updatedPostulante));
    }
    @PostMapping
    public ResponseEntity<Postulante> savePostulante(@RequestBody Postulante newPostulante) {
        Postulante savedPostulante = service.savePostulante(newPostulante);
        return ResponseEntity.ok(savedPostulante);
    }

    @DeleteMapping("/cedula/{nroCedula}")
    public ResponseEntity<Void> deletePostulanteByNroCedula(@PathVariable Integer nroCedula) {
        service.deletePostulanteByNroCedula(nroCedula);
        return ResponseEntity.noContent().build();
    }
}
