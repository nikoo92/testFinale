package it.example.testFinale.test.service.interfacce;

import it.example.testFinale.test.object.dto.ProdottoDTO;
import it.example.testFinale.test.object.model.Prodotto;

import java.util.List;

public interface ProdottoService {


    ProdottoDTO saveProdotto(ProdottoDTO prodottoDTO);



    List<ProdottoDTO> getAllProdotti();
}

