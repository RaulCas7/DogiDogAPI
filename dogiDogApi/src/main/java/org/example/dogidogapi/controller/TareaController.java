package org.example.dogidogapi.controller;
import org.example.dogidogapi.model.Tarea;
import org.example.dogidogapi.servicio.interfaces.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dogidog/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<?> obtenerTodas() {
        List<Tarea> tareas = tareaService.findAll();
        return tareas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        Tarea tarea = tareaService.findById(id);
        return tarea == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(tarea);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.guardar(tarea));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @RequestBody Tarea tarea) {
        Tarea actualizada = tareaService.actualizar(tarea, id);
        return actualizada == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        Tarea eliminada = tareaService.eliminar(id);
        return eliminada == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(eliminada);
    }
}

