package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Usuarioslogro;
import org.example.dogidogapi.model.UsuarioslogroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioslogroRepository extends JpaRepository<Usuarioslogro, UsuarioslogroId> {
}
