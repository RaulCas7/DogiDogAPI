package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Logro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogroRepository extends JpaRepository<Logro, Integer> {
}
