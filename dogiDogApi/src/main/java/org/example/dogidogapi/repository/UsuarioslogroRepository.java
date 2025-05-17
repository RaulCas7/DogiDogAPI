package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.model.Usuarioslogro;
import org.example.dogidogapi.model.UsuarioslogroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioslogroRepository extends JpaRepository<Usuarioslogro, UsuarioslogroId> {
    @Query("SELECT ul FROM Usuarioslogro ul JOIN FETCH ul.logro WHERE ul.usuario = :usuario")
    List<Usuarioslogro> findByUsuario(Usuario usuario);
}
