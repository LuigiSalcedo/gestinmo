package com.inmobicasaventas.gestinmo.api.documents.application.usecases;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.UpdloadDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.out.DocumentsRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class UploadDocumentImpl implements UpdloadDocumentUseCase {
    @Autowired
    private DocumentsRepository documentsRepository;

    @Override
    public boolean upload(Property property, String documentName, InputStream data) {
        return documentsRepository.saveDocument(property, documentName, data);
    }
}
