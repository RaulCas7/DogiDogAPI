package org.example.dogidogapi.controller;


import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.model.Valoracion;
import org.example.dogidogapi.servicio.interfaces.DocumentacionService;
import org.example.dogidogapi.servicio.interfaces.UsuarioService;
import org.example.dogidogapi.servicio.interfaces.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dogidog")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        List<Valoracion> valoraciones = valoracionService.findAll();
        return valoraciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(valoraciones);
    }

    @GetMapping("/valoraciones/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        Valoracion valoracion = valoracionService.findById(id);
        return valoracion == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(valoracion);
    }

    @PostMapping("/valoraciones")
    public ResponseEntity<?> guardar(@RequestBody Valoracion valoracion) {
        return ResponseEntity.ok(valoracionService.guardar(valoracion));
    }

    @PutMapping("/valoraciones/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @RequestBody Valoracion valoracion) {
        Valoracion actualizado = valoracionService.actualizar(valoracion, id);
        return actualizado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/valoraciones/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Valoracion eliminado = valoracionService.eliminar(id);
        return eliminado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(eliminado);
    }

    // Endpoint para obtener todas las valoraciones de un usuario
    @GetMapping("/valoraciones/usuario/{id}")
    public ResponseEntity<List<Valoracion>> obtenerValoracionesDeUsuario(@PathVariable Integer id) {
        // Obtenemos el usuario con el ID proporcionado
        Usuario usuario = usuarioService.findById(id);

        if (usuario != null) {
            // Llamamos al servicio para obtener las valoraciones del usuario
            List<Valoracion> valoraciones = valoracionService.obtenerValoracionesDeUsuario(usuario);

            if (!valoraciones.isEmpty()) {
                // Si encontramos valoraciones, las devolvemos en la respuesta
                return ResponseEntity.ok(valoraciones);
            } else {
                // Si no hay valoraciones, devolvemos una respuesta 404 (Not Found)
                return ResponseEntity.notFound().build();
            }
        } else {
            // Si el usuario no existe, devolvemos una respuesta 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
}
