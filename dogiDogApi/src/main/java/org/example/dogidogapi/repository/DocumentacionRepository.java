package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentacionRepository extends JpaRepository<Documentacion, Integer> {
    List<Documentacion> findByMascota(Mascota mascota);
}
