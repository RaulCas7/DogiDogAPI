package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Recorrido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecorridosmascotaRepository extends JpaRepository<Recorrido,Integer> {
    // Método para obtener todos los recorridos activos (duración es nula)
    @Query("SELECT r FROM Recorrido r WHERE r.duracion = 0 AND FUNCTION('DATE', r.fecha) = CURRENT_DATE")
    List<Recorrido> findAllActivos();
}
