package com.roshka.ApiRest.controller;

import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.service.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postulantes")
public class PostulanteController {

    @Autowired
    private PostulanteService postulanteService;

    @GetMapping
    public List<Postulante> getAllPostulantes() {
        return postulanteService.getAllPostulantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulante> getPostulanteById(@PathVariable Long id) {
        return postulanteService.getPostulanteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Postulante createPostulante(@RequestBody Postulante postulante) {
        return postulanteService.savePostulante(postulante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postulante> updatePostulante(@PathVariable Long id, @RequestBody Postulante postulante) {
        return postulanteService.getPostulanteById(id)
                .map(existingPostulante -> {
                    postulante.setId(existingPostulante.getId());
                    return ResponseEntity.ok(postulanteService.savePostulante(postulante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostulante(@PathVariable Long id) {
        if (postulanteService.getPostulanteById(id).isPresent()) {
            postulanteService.deletePostulante(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
