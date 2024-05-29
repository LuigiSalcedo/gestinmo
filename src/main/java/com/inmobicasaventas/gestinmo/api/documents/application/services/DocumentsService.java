package com.inmobicasaventas.gestinmo.api.documents.application.services;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.DeleteDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.DowloadDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.SearchDocumentByPropertyUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.UpdloadDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

@Service
public class DocumentsService implements
DowloadDocumentUseCase,
SearchDocumentByPropertyUseCase,
UpdloadDocumentUseCase,
DeleteDocumentUseCase
{
    @Autowired
    private DowloadDocumentUseCase dowloadDocumentUseCase;
    @Autowired
    private UpdloadDocumentUseCase updloadDocumentUseCase;
    @Autowired
    private SearchDocumentByPropertyUseCase searchDocumentByPropertyUseCase;
    @Autowired
    private DeleteDocumentUseCase deleteDocumentUseCase;


    @Override
    public List<Document> searchByProperty(Property property) {
        return searchDocumentByPropertyUseCase.searchByProperty(property);
    }

    @Override
    public Document download(Property property, Document document) {
        return dowloadDocumentUseCase.download(property, document);
    }

    @Override
    public boolean upload(Property property, String documentName, InputStream data) {
        return updloadDocumentUseCase.upload(property, documentName, data);
    }

    @Override
    public boolean delete(Property property, Document document) {
        return deleteDocumentUseCase.delete(property, document);
    }
    
}
