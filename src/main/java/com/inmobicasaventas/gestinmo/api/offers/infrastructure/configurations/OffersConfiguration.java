package com.inmobicasaventas.gestinmo.api.offers.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.offers.application.usecases.DeleteOfferImpl;
import com.inmobicasaventas.gestinmo.api.offers.application.usecases.SaveOfferImpl;
import com.inmobicasaventas.gestinmo.api.offers.application.usecases.SearchOfferByIdImpl;
import com.inmobicasaventas.gestinmo.api.offers.application.usecases.SearchOfferByPropertyImpl;
import com.inmobicasaventas.gestinmo.api.offers.application.usecases.SearchOffersHistoryImpl;
import com.inmobicasaventas.gestinmo.api.offers.application.usecases.SearchOffersWithFiltersImpl;
import com.inmobicasaventas.gestinmo.api.offers.application.usecases.UpdateOfferImpl;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.DeleteOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SaveOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOfferByIdUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOfferByPropertyUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOffersHistoryUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOffersWithFiltersUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.UpdateOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.adapters.OffersRepositoryAdapter;

@Configuration
public class OffersConfiguration {
    @Bean
    public OffersRepository offersRepository() {
        return new OffersRepositoryAdapter();
    }

    @Bean
    public DeleteOfferUseCase deleteOfferUseCase() {
        return new DeleteOfferImpl();
    }

    @Bean
    public SaveOfferUseCase saveOfferUseCase() {
        return new SaveOfferImpl();
    }

    @Bean
    public SearchOfferByIdUseCase searchOfferByIdUseCase() {
        return new SearchOfferByIdImpl();
    }

    @Bean
    public SearchOfferByPropertyUseCase searchOfferByPropertyUseCase() {
        return new SearchOfferByPropertyImpl();
    }

    @Bean
    public SearchOffersHistoryUseCase searchOffersHistoryUseCase() {
        return new SearchOffersHistoryImpl();
    }

    @Bean
    public UpdateOfferUseCase updateOfferUseCase() {
        return new UpdateOfferImpl();
    }

    @Bean
    public SearchOffersWithFiltersUseCase searchOffersWithFiltersUseCase() {
        return new SearchOffersWithFiltersImpl();
    }
}
