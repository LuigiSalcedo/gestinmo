package com.inmobicasaventas.gestinmo.api.documents.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.SearchDocumentByPropertyUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.out.DocumentsRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class SearchDocumentByPropertyImpl implements SearchDocumentByPropertyUseCase {
    @Autowired
    private DocumentsRepository documentsRepository;

    @Override
    public List<Document> searchByProperty(Property property) {
        if(!property.getActive()) {
            return null;
        }
        return documentsRepository.searchByProperty(property);
    }
    
}
