package it.example.testFinale.test.service;

import it.example.testFinale.test.mapstruck.DettaglioOrdineMapper;
import it.example.testFinale.test.object.dto.DettaglioOrdineDTO;
import it.example.testFinale.test.object.model.DettaglioOrdine;
import it.example.testFinale.test.object.model.Ordine;
import it.example.testFinale.test.object.model.Prodotto;
import it.example.testFinale.test.repository.DettaglioOrdineRepository;
import it.example.testFinale.test.repository.OrdineRepository;
import it.example.testFinale.test.repository.ProdottoRepository;
import it.example.testFinale.test.service.interfacce.DettaglioOrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DettaglioOrdineServiceImpl implements DettaglioOrdineService {
    @Autowired
    private DettaglioOrdineRepository dettaglioOrdineRepository;

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private DettaglioOrdineMapper dettaglioOrdineMapper;

    @Override
    public DettaglioOrdineDTO addProdottoToOrdine(Long ordineId, Long prodottoId, Integer quantita) {

        Ordine ordine = ordineRepository.findById(ordineId)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato"));
        Prodotto prodotto = prodottoRepository.findById(prodottoId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));


        DettaglioOrdine dettaglioOrdine = new DettaglioOrdine();
        dettaglioOrdine.setOrdine(ordine);
        dettaglioOrdine.setProdotto(prodotto);
        dettaglioOrdine.setQuantita(quantita);


        Double totaleProdotto = prodotto.getPrezzo() * quantita;
        dettaglioOrdine.setPrezzoTotale(totaleProdotto);


        dettaglioOrdine = dettaglioOrdineRepository.save(dettaglioOrdine);


        return dettaglioOrdineMapper.toDto(dettaglioOrdine);
    }

    @Override
    public Double calcolaTotaleOrdine(Long ordineId) {

        Ordine ordine = ordineRepository.findById(ordineId)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato"));


        return dettaglioOrdineRepository.findByOrdine(ordine).stream()
                .mapToDouble(DettaglioOrdine::getPrezzoTotale)
                .sum();
    }
}
