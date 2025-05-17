package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Logro;
import org.example.dogidogapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogroRepository extends JpaRepository<Logro, Integer> {
}
