package org.example.dogidogapi.controller;

import org.apache.commons.io.FilenameUtils;
import org.example.dogidogapi.model.Logro;
import org.example.dogidogapi.servicio.interfaces.LogroService;
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

@RestController
//Base de la URI
@RequestMapping("/dogidog")
public class LogroController {

    @Autowired
    private LogroService logroService;

    @GetMapping("/logros")
    public ResponseEntity<?> obtenerTodosLosLogros() {
        List<Logro> logros = logroService.findAll();
        if (logros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(logros);
        }
    }

    @GetMapping("/logros/{id}")
    public ResponseEntity<?> obtenerLogroPorId(@PathVariable int id) {
        Logro logro = logroService.findById(id);
        if (logro == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(logro);
        }
    }

    @PostMapping("/logros")
    public ResponseEntity<?> guardarLogro(@RequestBody Logro logro) {
        logroService.guardar(logro);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/logros/{id}")
    public ResponseEntity<?> actualizarLogro(@PathVariable int id, @RequestBody Logro logro) {
        Logro actual = logroService.findById(id);
        if (actual == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(logroService.actualizar(logro,id));
        }
    }
    @DeleteMapping("/logros/{id}")
    public ResponseEntity<?> eliminarLogro(@PathVariable int id) {
        Logro logro = logroService.findById(id);
        if (logro == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(logroService.eliminar(id));
        }
    }

    @PutMapping("/logros/{id}/emblema")
    public ResponseEntity<String> guardarEmblemaLogro(@PathVariable("id") Integer id,
                                                      @RequestParam("fichero") MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado un archivo.");
        }

        String nombreArchivo = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        String uploadDir = "logros/" + id + "/emblema/";

        // Eliminar y recrear el directorio
        File directory = new File(uploadDir);
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (!file.isDirectory()) file.delete();
            }
        } else {
            directory.mkdirs();
        }

        String extension = FilenameUtils.getExtension(nombreArchivo).toLowerCase();
        boolean esImagen = extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png");

        if (!esImagen) {
            return ResponseEntity.badRequest().body("El archivo debe ser una imagen JPG, JPEG o PNG.");
        }

        Logro logro = logroService.findById(id);
        if (logro == null) {
            return ResponseEntity.badRequest().body("Logro no encontrado.");
        }

        try {
            FileUploadUtil.guardarFichero(uploadDir, nombreArchivo, multipartFile);

            logro.setEmblema(nombreArchivo);
            logroService.guardar(logro);

            return ResponseEntity.ok("Emblema subido correctamente para el logro con ID " + id);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir el archivo: " + e.getMessage());
        }
    }
    @GetMapping("/logros/{id}/emblema")
    public ResponseEntity<Resource> getEmblemaLogro(@PathVariable("id") int id) {
        Logro logro = logroService.findById(id);

        if (logro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String nombreArchivo = logro.getEmblema();
        if (nombreArchivo == null || nombreArchivo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            Path filePath = Paths.get("logros/" + id + "/emblema/").resolve(nombreArchivo);
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
