package com.inmobicasaventas.gestinmo.api.documents.domain.ports.out;

import java.io.InputStream;
import java.util.List;

import com.inmobicasaventas.gestinmo.api.documents.domain.models.Document;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface DocumentsRepository {
    List<Document> searchByProperty(Property property);
    Document searchDocument(Property property, Document document);
    boolean saveDocument(Property property, String documentName, InputStream data);
    boolean deleteDocument(Property property, Document document);
}
