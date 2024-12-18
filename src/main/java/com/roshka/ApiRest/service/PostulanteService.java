package com.roshka.ApiRest.service;

import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.repository.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roshka.ApiRest.exception.PostulanteNoEncontradoException;

import java.util.List;
import java.util.Optional;
@Service
public class PostulanteService {

    @Autowired
    private PostulanteRepository repository;


    public List<Postulante> getAllPostulantes() {
        return repository.findAll();
    }

    public List<Postulante> getPostulantesByNroCedula(Integer nroCedula) {
        return repository.findByNroCedula(nroCedula);
    }

    public Postulante updatePostulante(Long id, Postulante updatedPostulante) {
        Optional<Postulante> postulanteOptional = repository.findById(id);

        if (postulanteOptional.isPresent()) {
            Postulante postulante = postulanteOptional.get();
            postulante.setNombre(updatedPostulante.getNombre());
            postulante.setApellido(updatedPostulante.getApellido());
            postulante.setNroCedula(updatedPostulante.getNroCedula());
            postulante.setCorreo(updatedPostulante.getCorreo());
            postulante.setTelefono(updatedPostulante.getTelefono());
            postulante.setDireccion(updatedPostulante.getDireccion());
            postulante.setExperienciaLaboral(updatedPostulante.getExperienciaLaboral());
            postulante.setEstudioUniversitario(updatedPostulante.getEstudioUniversitario());
            postulante.setNotebook(updatedPostulante.getNotebook());
            postulante.setAceptado(updatedPostulante.getAceptado());
            postulante.setBootcampId(updatedPostulante.getBootcampId());
            return repository.save(postulante);
        } else {
            throw new RuntimeException("Postulante no encontrado con ID: " + id);
        }
    }

    public void deletePostulanteByNroCedula(Integer nroCedula) {
        Optional<Postulante> postulante = repository.findByNroCedula(nroCedula).stream().findFirst();
        if (postulante.isPresent()) {
            repository.delete(postulante.get());
        } else {
            throw new RuntimeException("Postulante no encontrado con nroCedula: " + nroCedula);
        }
    }
}
