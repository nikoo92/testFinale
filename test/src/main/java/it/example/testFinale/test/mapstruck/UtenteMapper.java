package it.example.testFinale.test.mapstruck;

import it.example.testFinale.test.object.dto.UtenteDTO;
import it.example.testFinale.test.object.model.Utente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    UtenteDTO toDto (Utente utente);

    Utente toEntity (UtenteDTO utenteDTO);
}
