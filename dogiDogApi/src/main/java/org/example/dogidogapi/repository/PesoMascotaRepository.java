package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.PesoMascota;
import org.example.dogidogapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesoMascotaRepository extends JpaRepository<PesoMascota, Integer> {
    List<PesoMascota> findByMascota(Mascota mascota);
}
