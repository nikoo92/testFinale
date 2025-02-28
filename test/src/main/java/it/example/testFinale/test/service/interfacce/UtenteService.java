package it.example.testFinale.test.service.interfacce;

import it.example.testFinale.test.object.dto.UtenteDTO;
import it.example.testFinale.test.object.model.Utente;

import java.util.List;

public interface UtenteService {


    List<UtenteDTO> getAllUtenti();


    UtenteDTO getUtenteById(Long id);

    UtenteDTO saveUtente(UtenteDTO utente);
}

