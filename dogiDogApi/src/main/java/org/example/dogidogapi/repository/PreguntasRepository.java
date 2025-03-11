package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntasRepository extends JpaRepository<Pregunta,Integer> {
}
