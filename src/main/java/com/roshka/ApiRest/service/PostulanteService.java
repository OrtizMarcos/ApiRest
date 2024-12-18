package com.roshka.ApiRest.service;

import com.roshka.ApiRest.model.Postulante;
import com.roshka.ApiRest.repository.PostulanteRepository;
import com.roshka.ApiRest.exception.PostulanteNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostulanteService {

    @Autowired
    private PostulanteRepository repository;

    // Obtener todos los postulantes
    public List<Postulante> getAllPostulantes() {
        return repository.findAll();
    }

    public Postulante savePostulante(Postulante postulante) {
        return repository.save(postulante);
    }


    // Obtener postulantes por número de cédula
    public List<Postulante> getPostulantesByNroCedula(Integer nroCedula) {
        if (nroCedula == null || nroCedula <= 0) {
            throw new IllegalArgumentException("El número de cédula no puede ser nulo ni negativo.");
        }
        List<Postulante> postulantes = repository.findByNroCedula(nroCedula);
        if (postulantes.isEmpty()) {
            throw new PostulanteNoEncontradoException("No se encontraron postulantes con el número de cédula: " + nroCedula);
        }
        return postulantes;
    }

    // Actualizar un postulante existente
    public Postulante updatePostulante(Long id, Postulante updatedPostulante) {
        if (updatedPostulante == null) {
            throw new IllegalArgumentException("El objeto Postulante actualizado no puede ser nulo.");
        }

        return repository.findById(id)
                .map(existingPostulante -> {
                    // Actualizar solo los campos necesarios
                    existingPostulante.setNombre(updatedPostulante.getNombre());
                    existingPostulante.setApellido(updatedPostulante.getApellido());
                    existingPostulante.setNroCedula(updatedPostulante.getNroCedula());
                    existingPostulante.setCorreo(updatedPostulante.getCorreo());
                    existingPostulante.setTelefono(updatedPostulante.getTelefono());
                    existingPostulante.setDireccion(updatedPostulante.getDireccion());
                    existingPostulante.setExperienciaLaboral(updatedPostulante.getExperienciaLaboral());
                    existingPostulante.setEstudioUniversitario(updatedPostulante.getEstudioUniversitario());
                    existingPostulante.setNotebook(updatedPostulante.getNotebook());
                    existingPostulante.setAceptado(updatedPostulante.getAceptado());
                    existingPostulante.setBootcampId(updatedPostulante.getBootcampId());
                    return repository.save(existingPostulante);
                })
                .orElseThrow(() -> new PostulanteNoEncontradoException("Postulante no encontrado con ID: " + id));
    }

    // Eliminar un postulante por número de cédula
    public void deletePostulanteByNroCedula(Integer nroCedula) {
        if (nroCedula == null || nroCedula <= 0) {
            throw new IllegalArgumentException("El número de cédula no puede ser nulo ni negativo.");
        }

        Optional<Postulante> postulante = repository.findByNroCedula(nroCedula).stream().findFirst();
        if (postulante.isPresent()) {
            repository.delete(postulante.get());
        } else {
            throw new PostulanteNoEncontradoException("Postulante no encontrado con nroCedula: " + nroCedula);
        }
    }
}
