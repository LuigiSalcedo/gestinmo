package com.inmobicasaventas.gestinmo.api.properties.infrastructure.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.NeighborhoodRepository;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.repositories.JpaNeighborhoodRepository;

public class NeighborhoodRepositoryAdapter implements NeighborhoodRepository {
    @Autowired
    private JpaNeighborhoodRepository jpaNeighborhoodRepository;

    @Override
    public List<Neighborhood> searchAll() {
        return jpaNeighborhoodRepository.findAll();
    }

    @Override
    public List<Neighborhood> searchByName(String name) {
        return jpaNeighborhoodRepository.findByNameContaining(name);
    }

    @Override
    public Neighborhood searchById(Integer id) {
        var neighborhood = jpaNeighborhoodRepository.findById(id);
        if(neighborhood.isEmpty()) {
            return null;
        }
        return neighborhood.get(); 
    }

}
