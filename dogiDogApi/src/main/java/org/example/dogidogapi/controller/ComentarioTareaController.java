package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.ComentarioTarea;
import org.example.dogidogapi.servicio.interfaces.ComentarioTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dogidog/comentarios")
public class ComentarioTareaController {

    @Autowired
    private ComentarioTareaService comentarioService;

    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        List<ComentarioTarea> comentarios = comentarioService.findAll();
        return comentarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(comentarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        ComentarioTarea comentario = comentarioService.findById(id);
        return comentario == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(comentario);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody ComentarioTarea comentario) {
        return ResponseEntity.ok(comentarioService.guardar(comentario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @RequestBody ComentarioTarea comentario) {
        ComentarioTarea actualizado = comentarioService.actualizar(comentario, id);
        return actualizado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        ComentarioTarea eliminado = comentarioService.eliminar(id);
        return eliminado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(eliminado);
    }
}
