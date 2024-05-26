package com.inmobicasaventas.gestinmo.api.documents.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.DowloadDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.out.DocumentsRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class DownloadDocumentImpl implements DowloadDocumentUseCase {
    @Autowired
    private DocumentsRepository documentsRepository;

    @Override
    public Document download(Property property, Document document) {
        return documentsRepository.searchDocument(property, document);
    }
    
}
