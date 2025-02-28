package it.example.testFinale.test.service.interfacce;

import it.example.testFinale.test.object.dto.DettaglioOrdineDTO;
import it.example.testFinale.test.object.model.DettaglioOrdine;

public interface DettaglioOrdineService {


    DettaglioOrdineDTO addProdottoToOrdine(Long ordineId, Long prodottoId, Integer quantita);


    Double calcolaTotaleOrdine(Long ordineId);
}

