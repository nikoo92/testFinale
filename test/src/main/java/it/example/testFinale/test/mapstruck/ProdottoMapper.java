package it.example.testFinale.test.mapstruck;

import it.example.testFinale.test.object.dto.ProdottoDTO;
import it.example.testFinale.test.object.model.Prodotto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdottoMapper {

    ProdottoDTO toDto(Prodotto prodotto);

    Prodotto toEntity(ProdottoDTO prodottoDTO);
}
