package org.example.dogidogapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.example.dogidogapi.model.Documentacion;
import org.example.dogidogapi.model.Mascota;
import org.example.dogidogapi.model.Notificacion;
import org.example.dogidogapi.model.Usuario;
import org.example.dogidogapi.servicio.interfaces.DocumentacionService;
import org.example.dogidogapi.servicio.interfaces.MascotaService;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/dogidog")
public class DocumentacionController {

    @Autowired
    private DocumentacionService documentacionService;
    @Autowired
    private MascotaService mascotaService;

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
    public ResponseEntity<?> guardarDocumentacionSinArchivo(@RequestBody Documentacion documentacion){
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

    @PutMapping("/documentacion/{id}/archivo")
    public ResponseEntity<String> actualizarArchivoDocumentacion(@PathVariable("id") Integer id,
                                                                 @RequestParam("fichero") MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha seleccionado un archivo.");
        }

        String nombreArchivo = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        String uploadDir = "documentacion/" + id + "/archivos/";

        // Eliminar y recrear el directorio
        File directory = new File(uploadDir);
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (!file.isDirectory()) file.delete();
            }
        } else {
            directory.mkdirs();
        }

        // Verificar el tipo de archivo si es necesario (puedes añadir otros tipos de archivo si lo deseas)
        String extension = FilenameUtils.getExtension(nombreArchivo).toLowerCase();
        boolean esArchivoPermitido = extension.equals("pdf") || extension.equals("jpg") || extension.equals("jpeg")
                || extension.equals("png");  // Agrega más extensiones si es necesario

        if (!esArchivoPermitido) {
            return ResponseEntity.badRequest().body("El archivo debe ser un PDF, JPG, JPEG o PNG.");
        }

        // Aquí deberías llamar a tu servicio para obtener la documentación correspondiente
        Documentacion documentacion = documentacionService.findById(id);
        if (documentacion == null) {
            return ResponseEntity.badRequest().body("Documentación no encontrada.");
        }

        try {
            // Usar el FileUploadUtil para guardar el archivo en el directorio
            FileUploadUtil.guardarFichero(uploadDir, nombreArchivo, multipartFile);

            // Actualizar la ruta del archivo en la entidad de la documentación
            documentacion.setArchivo(uploadDir + nombreArchivo);
            documentacionService.guardar(documentacion);

            return ResponseEntity.ok("Archivo de documentación actualizado correctamente para el ID " + id);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al subir el archivo: " + e.getMessage());
        }
    }

    @GetMapping("/documentacion/{id}/archivo")
    public ResponseEntity<Resource> getArchivoDocumentacion(@PathVariable("id") Integer id) {
        Documentacion doc = documentacionService.findById(id);

        if (doc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String nombreArchivo = doc.getArchivo();
        if (nombreArchivo == null || nombreArchivo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try {
            Path filePath = Paths.get(nombreArchivo);
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            // Detectar tipo MIME automáticamente
            String mimeType = Files.probeContentType(filePath);
            if (mimeType == null) {
                mimeType = "application/octet-stream"; // Fallback genérico
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(mimeType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/documentacion/mascota")
    public ResponseEntity<?> obtenerLosDocumentosMascota(@RequestParam int mascotaId) {
        Mascota mascota = mascotaService.findById(mascotaId);
        if(mascota == null) {
            return ResponseEntity.notFound().build();
        }else{
            List<Documentacion> documentos = documentacionService.buscarDocumentosPorMascota(mascota);
            if(documentos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }else {
                return ResponseEntity.ok(documentos);
            }
        }
    }
}
