package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Raza;
import org.example.dogidogapi.model.Usuarioslogro;
import org.example.dogidogapi.model.UsuarioslogroId;
import org.example.dogidogapi.servicio.interfaces.RazaService;
import org.example.dogidogapi.servicio.interfaces.UsuarioslogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogidog")
public class UsuariologroController {
    @Autowired
    private UsuarioslogroService usuarioslogroService;

    @GetMapping("/usuarioLogros")
    public ResponseEntity<?> obtenerTodosLosLogrosDeUsuarios() {
        List<Usuarioslogro> usuariosLogro = usuarioslogroService.findAll();
        if (usuariosLogro.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(usuariosLogro);
        }
    }

    @GetMapping("/usuarioLogros/{id}")
    public ResponseEntity<?> obtenerUsuarioLogroPorId(@PathVariable UsuarioslogroId id) {
        Usuarioslogro usuarioslogro = usuarioslogroService.findById(id);
        if (usuarioslogro == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(usuarioslogro);
        }
    }

    @PostMapping("/usuarioLogros")
    public ResponseEntity<?> guardarUsuarioLogro(@RequestBody Usuarioslogro usuarioslogro) {
        usuarioslogroService.guardar(usuarioslogro);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/usuarioLogros/{id}")
    public ResponseEntity<?> actualizarUsuarioLogro(@PathVariable UsuarioslogroId id, @RequestBody Usuarioslogro usuarioslogro) {
        Usuarioslogro actual = usuarioslogroService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(usuarioslogroService.actualizar(usuarioslogro,id));
        }
    }
    @DeleteMapping("/usuarioLogros/{id}")
    public ResponseEntity<?> eliminarUsuarioLogro(@PathVariable UsuarioslogroId id) {
        Usuarioslogro usuarioslogro = usuarioslogroService.findById(id);
        if (usuarioslogro == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(usuarioslogroService.eliminar(id));
        }
    }
}
