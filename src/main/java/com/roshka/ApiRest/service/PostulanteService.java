package com.roshka.ApiRest.service;

import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.repository.PostulanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roshka.ApiRest.exception.PostulanteNoEncontradoException;

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

    public Optional<Postulante> getPostulanteByCedula(String nroCedula) {
        return postulanteRepository.findByNroCedula(nroCedula);
    }

    public void deletePostulante(Long id) {
        postulanteRepository.deleteById(id);
    }

    @Transactional
    public void eliminarPostulantePorCedula(String nroCedula) {
        postulanteRepository.deleteByNroCedula(nroCedula);  // Llama al repositorio para eliminar por cédula

    }
}
