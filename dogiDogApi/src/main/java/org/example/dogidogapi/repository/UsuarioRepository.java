package org.example.dogidogapi.repository;

import org.example.dogidogapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUsuarioByEmailAndPassword(String email, String password);
    Usuario findUsuarioByEmail(String email);
}
