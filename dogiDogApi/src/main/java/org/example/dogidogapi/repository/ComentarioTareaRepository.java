package org.example.dogidogapi.repository;
import org.example.dogidogapi.model.ComentarioTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioTareaRepository extends JpaRepository<ComentarioTarea, Integer> {
}
