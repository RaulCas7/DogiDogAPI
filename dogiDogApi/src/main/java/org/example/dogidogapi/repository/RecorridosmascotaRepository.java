package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Recorrido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecorridosmascotaRepository extends JpaRepository<Recorrido,Integer> {
}
