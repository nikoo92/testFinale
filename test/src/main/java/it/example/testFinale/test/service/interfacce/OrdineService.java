package it.example.testFinale.test.service.interfacce;

import it.example.testFinale.test.object.dto.OrdineDTO;
import it.example.testFinale.test.object.model.Ordine;

import java.time.LocalDate;
import java.util.List;

public interface OrdineService {



    List<OrdineDTO> getAllOrdini();

    OrdineDTO saveOrdine (OrdineDTO ordineDTO);

    OrdineDTO updateStatoOrdine(Long ordineId, String nuovoStato);
}

