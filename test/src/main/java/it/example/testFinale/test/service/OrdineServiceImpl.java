package it.example.testFinale.test.service;

import it.example.testFinale.test.mapstruck.OrdineMapper;
import it.example.testFinale.test.mapstruck.UtenteMapper;
import it.example.testFinale.test.object.dto.DettaglioOrdineDTO;
import it.example.testFinale.test.object.dto.OrdineDTO;
import it.example.testFinale.test.object.dto.UtenteDTO;
import it.example.testFinale.test.object.model.DettaglioOrdine;
import it.example.testFinale.test.object.model.Ordine;
import it.example.testFinale.test.object.model.Prodotto;
import it.example.testFinale.test.object.model.Utente;
import it.example.testFinale.test.repository.OrdineRepository;
import it.example.testFinale.test.repository.ProdottoRepository;
import it.example.testFinale.test.repository.UtenteRepository;
import it.example.testFinale.test.service.interfacce.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service

public class OrdineServiceImpl implements OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private OrdineMapper ordineMapper;

    @Autowired
    private UtenteRepository utenteRepository;  // Repository per Utente

    @Autowired
    private UtenteMapper utenteMapper;

    @Override
    public OrdineDTO saveOrdine(OrdineDTO ordineDTO) {
        Ordine ordine = new Ordine();
        ordine.setData(LocalDate.now());
        ordine.setStato(ordineDTO.getStato());


        if (ordineDTO.getUtente() != null && ordineDTO.getUtente()!= null) {
            Utente utente = utenteRepository.findById(ordineDTO.getUtente().getId())
                    .orElseThrow(() -> new RuntimeException("Utente non trovato"));
            ordine.setUtente(utente);
        }


        ordine.setDettagli(new ArrayList<>());


        double totale = 0;
        if (ordineDTO.getDettagli() != null) {
            for (DettaglioOrdineDTO dettaglioDTO : ordineDTO.getDettagli()) {
                DettaglioOrdine dettaglio = new DettaglioOrdine();
                dettaglio.setQuantita(dettaglioDTO.getQuantita());


                Prodotto prodotto = prodottoRepository.findById(dettaglioDTO.getProdottoId())
                        .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));
                dettaglio.setProdotto(prodotto);
                dettaglio.setOrdine(ordine);

                dettaglio.setPrezzoTotale(dettaglioDTO.getQuantita() * prodotto.getPrezzo());


                totale += dettaglio.getPrezzoTotale();


                ordine.getDettagli().add(dettaglio);
            }
        }


        ordine.setTotale(totale);


        ordine = ordineRepository.save(ordine);


        return ordineMapper.toDto(ordine);
    }


    @Override
    public List<OrdineDTO> getAllOrdini() {
        List<Ordine> ordini = ordineRepository.findAll();
        return ordini.stream()
                .map(ordineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdineDTO updateStatoOrdine(Long ordineId, String nuovoStato) {
        Ordine ordine = ordineRepository.findById(ordineId)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato"));
        ordine.setStato(nuovoStato);
        ordine = ordineRepository.save(ordine);
        return ordineMapper.toDto(ordine);
    }

    @Override
    public Double getTotalByUtenteId(Long utenteId) {
        List<Ordine> ordini = ordineRepository.findByUtenteId(utenteId);

        return ordini.stream()
                .mapToDouble(ordine -> ordine.getTotale())
                .sum();
    }


    public List<OrdineDTO> getOrdineDate(LocalDate startDate, LocalDate endDate) {
        return ordineRepository.findByDataBetween(startDate, endDate).stream().map(ordineMapper::toDto).collect(Collectors.toList());
    }
}
