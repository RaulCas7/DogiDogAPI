package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Notificacion;
import org.example.dogidogapi.model.Pregunta;
import org.example.dogidogapi.servicio.interfaces.NotificacionService;
import org.example.dogidogapi.servicio.interfaces.PreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Base de la URI
@RequestMapping("/dogidog")
public class PreguntasController {
    @Autowired
    private PreguntasService preguntasService;

    @GetMapping("/preguntas")
    public ResponseEntity<?> obtenerTodasLasPreguntas() {
        List<Pregunta> preguntas = preguntasService.findAll();
        if (preguntas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(preguntas);
        }
    }

    @GetMapping("/preguntas/{id}")
    public ResponseEntity<?> obtenerPreguntaPorId(@PathVariable int id) {
        Pregunta pregunta = preguntasService.findById(id);
        if (pregunta == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(pregunta);
        }
    }

    @PostMapping("/preguntas")
    public ResponseEntity<?> guardarPregunta(@RequestBody Pregunta pregunta) {
        preguntasService.guardar(pregunta);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/preguntas/{id}")
    public ResponseEntity<?> actualizarPregunta(@PathVariable int id, @RequestBody Pregunta pregunta) {
        Pregunta actual = preguntasService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(preguntasService.actualizar(pregunta,id));
        }
    }
    @DeleteMapping("/preguntas/{id}")
    public ResponseEntity<?> eliminarPregunta(@PathVariable int id) {
        Pregunta pregunta = preguntasService.findById(id);
        if (pregunta == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(preguntasService.eliminar(id));
        }
    }

    @GetMapping("/preguntas/buscar")
    public ResponseEntity<Pregunta> buscarPorPregunta(@RequestParam("texto") String texto) {
        Pregunta pregunta = preguntasService.buscarPorPregunta(texto);

        if (pregunta != null) {
            return ResponseEntity.ok(pregunta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
