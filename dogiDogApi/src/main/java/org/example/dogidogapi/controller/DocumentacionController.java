package org.example.dogidogapi.controller;

import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.servicio.interfaces.DocumentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogidog")
public class DocumentacionController {

    @Autowired
    private DocumentacionService documentacionService;

    @GetMapping("/documentacion")
    public ResponseEntity<?> obtenerTodaLaDocumentacion(){
        List<Documentacion> documentacion = documentacionService.findAll();
        if(documentacion.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(documentacion);
        }
    }

    @GetMapping("/documentacion/{id}")
    public ResponseEntity<?> obtenerDocumentacionPorId(@PathVariable int id){
        Documentacion documentacion = documentacionService.findById(id);
        if(documentacion == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(documentacion);
        }
    }

    @PostMapping("/documentacion")
    public ResponseEntity<?> guardarDocumentacion(@RequestBody Documentacion documentacion){
        Documentacion nuevo = documentacionService.guardar(documentacion);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/documentacion/{id}")
    public ResponseEntity<?> actualizarDocumentacion(@PathVariable Integer id,
                                                     @RequestBody Documentacion documentacion){
        Documentacion actualizar = documentacionService.findById(id);
        if(actualizar == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(documentacionService.actualizar(documentacion,id));
        }
    }

    @DeleteMapping("/documentacion/{id}")
    public ResponseEntity<?> eliminarDocumentacion(@PathVariable Integer id){
        Documentacion documentacion = documentacionService.findById(id);
        if(documentacion == null){
            return ResponseEntity.notFound().build();
        }else {

            return ResponseEntity.ok(documentacionService.eliminar(id));
        }
    }
}
