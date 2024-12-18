package com.roshka.ApiRest.repository;

import com.roshka.ApiRest.model.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante, Long> {
    List<Postulante> findByNroCedula(Integer nroCedula);

}
