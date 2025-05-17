package org.example.dogidogapi.controller;

import org.apache.commons.io.FilenameUtils;
import org.example.dogidogapi.model.Raza;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.servicio.interfaces.RazaService;
import org.example.dogidogapi.servicio.interfaces.UsuarioService;
import org.example.dogidogapi.servicio.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dogidog")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<?> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(usuarios);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(usuario);
        }
    }

    @GetMapping("/usuarios/inicio")
    public ResponseEntity<?> inicioSesion(@RequestParam String email, @RequestParam String password) {
        Usuario usuario = usuarioService.inicioSesion(email, password);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(usuario);
        }
    }

    @GetMapping("/usuarios/email/{email}")
    public ResponseEntity<?> verificarUsuario(@PathVariable String email) {
        Usuario usuario = usuarioService.verificarEmail(email);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(usuario);
        }
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario) {
        usuarioService.guardar(usuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario actual = usuarioService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(usuarioService.actualizar(usuario,id));
        }
    }
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(usuarioService.eliminar(id));
        }
    }

    @PutMapping("/actualizar-coordenadas/{id}")
    public ResponseEntity<?> actualizarCoordenadas(@PathVariable Integer id, @RequestParam Double latitud, @RequestParam Double longitud) {
        // Llamamos al servicio para actualizar las coordenadas
        Usuario usuario = usuarioService.actualizarCoordenadas(id, latitud, longitud);

        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PutMapping("/limpiar-coordenadas/{id}")
    public ResponseEntity<?> limpiarCoordenadas(@PathVariable Integer id) {
        // Llamamos al servicio para poner las coordenadas a null
        Usuario usuario = usuarioService.terminarPaseo(id);

        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }


}
