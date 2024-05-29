package com.inmobicasaventas.gestinmo.api.documents.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.DeleteDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.out.DocumentsRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class DeleteDocumentImpl implements DeleteDocumentUseCase {
    @Autowired
    private DocumentsRepository documentsRepository;
    @Override
    public boolean delete(Property property, Document document) {
        return documentsRepository.deleteDocument(property, document);
    }
    
}
