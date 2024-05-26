package com.inmobicasaventas.gestinmo.api.documents.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.documents.application.usecases.DownloadDocumentImpl;
import com.inmobicasaventas.gestinmo.api.documents.application.usecases.SearchDocumentByPropertyImpl;
import com.inmobicasaventas.gestinmo.api.documents.application.usecases.UploadDocumentImpl;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.DowloadDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.SearchDocumentByPropertyUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.in.UpdloadDocumentUseCase;
import com.inmobicasaventas.gestinmo.api.documents.domain.ports.out.DocumentsRepository;
import com.inmobicasaventas.gestinmo.api.documents.infrastructure.adapters.VirtualMemoryDocumentRepositoryAdapter;

@Configuration
public class DocumentsConfiguration {
    @Bean
    public DocumentsRepository documentsRepository() {
        return new VirtualMemoryDocumentRepositoryAdapter();
    } 

    @Bean
    public UpdloadDocumentUseCase updloadDocumentUseCase() {
        return new UploadDocumentImpl();
    }

    @Bean
    public DowloadDocumentUseCase documentUseCase() {
        return new DownloadDocumentImpl();
    }

    @Bean
    public SearchDocumentByPropertyUseCase documentByPropertyUseCase() {
        return new SearchDocumentByPropertyImpl();
    }
}
