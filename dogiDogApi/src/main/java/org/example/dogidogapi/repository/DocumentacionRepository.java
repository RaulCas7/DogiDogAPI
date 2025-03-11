package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Documentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentacionRepository extends JpaRepository<Documentacion, Integer> {
}
