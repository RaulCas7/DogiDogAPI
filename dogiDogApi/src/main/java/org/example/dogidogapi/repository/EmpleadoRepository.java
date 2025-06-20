package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Empleado findByUsuarioId(Integer id);
}
