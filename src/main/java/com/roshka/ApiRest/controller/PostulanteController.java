package com.roshka.ApiRest.controller;

import com.roshka.ApiRest.dto.PostulanteDTO;
import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.service.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteService postulanteService;

    // Obtener todos los postulantes con nroCedula en lugar de id
    @GetMapping
    public List<PostulanteDTO> getAllPostulantes() {
        return postulanteService.getAllPostulantes()
                .stream()
                .map(postulante -> new PostulanteDTO(postulante.getNroCedula(), postulante.getNombre()))
                .collect(Collectors.toList());
    }

    // Obtener un postulante por id, pero mostrar nroCedula en la respuesta
    @GetMapping("/{id}")
    public ResponseEntity<PostulanteDTO> getPostulanteById(@PathVariable Long id) {
        return postulanteService.getPostulanteById(id)
                .map(postulante -> ResponseEntity.ok(new PostulanteDTO(postulante.getNroCedula(), postulante.getNombre())))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo postulante
    @PostMapping
    public Postulante createPostulante(@RequestBody Postulante postulante) {
        return postulanteService.savePostulante(postulante);
    }

    // Actualizar un postulante existente
    @PutMapping("/{id}")
    public ResponseEntity<Postulante> updatePostulante(@PathVariable Long id, @RequestBody Postulante postulante) {
        return postulanteService.getPostulanteById(id)
                .map(existingPostulante -> {
                    postulante.setId(existingPostulante.getId());
                    return ResponseEntity.ok(postulanteService.savePostulante(postulante));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    // Obtener un postulante por nroCedula
    @GetMapping("/cedula/{nroCedula}")
    public ResponseEntity<PostulanteDTO> getPostulanteByCedula(@PathVariable String nroCedula) {
        return postulanteService.getPostulanteByCedula(nroCedula)
                .map(postulante -> ResponseEntity.ok(new PostulanteDTO(postulante.getNroCedula(), postulante.getNombre())))
                .orElse(ResponseEntity.notFound().build());


    }

    // Eliminar un postulante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostulante(@PathVariable Long id) {
        if (postulanteService.getPostulanteById(id).isPresent()) {
            postulanteService.deletePostulante(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
