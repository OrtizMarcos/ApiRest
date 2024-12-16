package com.roshka.ApiRest.service;

import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.repository.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostulanteService {

    @Autowired
    private PostulanteRepository postulanteRepository;

    public List<Postulante> getAllPostulantes() {
        return postulanteRepository.findAll();
    }

    public Optional<Postulante> getPostulanteById(Long id) {
        return postulanteRepository.findById(id);
    }

    public Postulante savePostulante(Postulante postulante) {
        return postulanteRepository.save(postulante);
    }

    public void deletePostulante(Long id) {
        postulanteRepository.deleteById(id);
    }
}
