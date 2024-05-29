package com.inmobicasaventas.gestinmo.api.documents.infrastructure.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inmobicasaventas.gestinmo.api.documents.application.services.DocumentsService;
import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.documents.infrastructure.exceptions.NoFIleException;
import com.inmobicasaventas.gestinmo.api.documents.infrastructure.mappers.DocumentMapper;
import com.inmobicasaventas.gestinmo.api.properties.application.services.PropertyService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(path = "api/private/documents")
@Tag(name = "Documentos", description = "Endpoints relacionados a documentos")
public class DocumentsController {
    @Autowired
    private DocumentsService documentsService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private DocumentMapper documentMapper;

    @PostMapping("save/{propertyId}")
    public ResponseEntity<?> saveDocument(@PathVariable int propertyId, MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            throw new NoFIleException();
        }

        var property = propertyService.searchPropertyById(propertyId);
        if(property == null) {
            return ResponseEntity.notFound().build();
        }
        var saved = documentsService.upload(property, file.getOriginalFilename(), file.getInputStream());
        if(!saved) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("search/{propertyId}")
    public ResponseEntity<List<String>> searchAllDocuments(@PathVariable int propertyId) {
        var property = propertyService.searchPropertyById(propertyId);
        if(property == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(documentMapper.toNamesList(
            documentsService.searchByProperty(property)
        ));
    }

    @GetMapping("search/{propertyId}/{fileName}")
    public ResponseEntity<FileSystemResource> searchSpecifyDocument(
        @PathVariable int propertyId,
        @PathVariable String fileName
    ){
        var property = propertyService.searchPropertyById(propertyId);
        if(property == null) {
            return ResponseEntity.notFound().build();
        }
        var file = documentsService.download(property, new Document(fileName, null));
        if(file == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new FileSystemResource(file.getFile()));
    }

    @DeleteMapping("delete/{propertyId}/{fileName}")
    public ResponseEntity<?> deleteDocument(
        @PathVariable int propertyId,
        @PathVariable String fileName
    ){
        var property = propertyService.searchPropertyById(propertyId);
        if(property == null) {
            return ResponseEntity.notFound().build();
        }
        var deleted = documentsService.delete(property, new Document(fileName, null));
        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
    
}
