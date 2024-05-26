package com.inmobicasaventas.gestinmo.api.documents.infrastructure.adapters;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.out.DocumentsRepository;
import com.inmobicasaventas.gestinmo.api.documents.infrastructure.repositries.HardDiskRespository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class VirtualMemoryDocumentRepositoryAdapter implements DocumentsRepository {
    @Autowired
    private HardDiskRespository hardDiskRespository;

    @Override
    public List<Document> searchByProperty(Property property) {
        return hardDiskRespository
        .loadFilesFromFolder(property.getId().toString())
        .stream().map(file -> new Document(file.getFileName().toString(), file.toFile())).toList();
    }

    @Override
    public Document searchDocument(Property property, Document document) {
        var fileOpt = searchByProperty(property).stream().filter(d -> d.equals(document)).findFirst();
        if(fileOpt.isEmpty()) {
            return null;
        }
        return fileOpt.get();
    }

    @Override
    public boolean saveDocument(Property property, String documentName, InputStream data) {
        Path filePointer = Path.of(property.getId().toString()).resolve(documentName);
        return hardDiskRespository.saveFile(filePointer, data);
    }
    
}
