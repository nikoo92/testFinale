package it.example.testFinale.test.mapstruck;

import it.example.testFinale.test.object.dto.DettaglioOrdineDTO;
import it.example.testFinale.test.object.model.DettaglioOrdine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DettaglioOrdineMapper {

    DettaglioOrdineDTO toDto(DettaglioOrdine dettaglioOrdine);

    DettaglioOrdine toEntity(DettaglioOrdineDTO dettaglioOrdineDTO);
}
