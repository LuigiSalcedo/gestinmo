package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchNeighborhoodDto;

@Component
public class NeighborhoodMapper {
    public SearchNeighborhoodDto toSearchNeighborhoodDto(Neighborhood neighborhood) {
        return new SearchNeighborhoodDto(neighborhood);
    }

    public List<SearchNeighborhoodDto> toSearchNeighborhoodDtoList(List<Neighborhood> neighborhoods) {
        return neighborhoods.stream().map(n -> toSearchNeighborhoodDto(n)).toList();
    }
}
