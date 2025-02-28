package it.example.testFinale.test.mapstruck;

import it.example.testFinale.test.object.dto.OrdineDTO;
import it.example.testFinale.test.object.model.Ordine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdineMapper {

    OrdineDTO toDto(Ordine ordine);

    Ordine toEntity(OrdineDTO ordineDTO);
}
