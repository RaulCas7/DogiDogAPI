package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.model.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Integer> {
    List<Valoracion> findByValorado(Usuario usuario);
}
