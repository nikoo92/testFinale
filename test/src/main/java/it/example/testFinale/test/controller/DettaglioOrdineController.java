package it.example.testFinale.test.controller;


import it.example.testFinale.test.object.dto.DettaglioOrdineDTO;
import it.example.testFinale.test.object.model.DettaglioOrdine;
import it.example.testFinale.test.service.interfacce.DettaglioOrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dettagliordine")
public class DettaglioOrdineController {

    @Autowired
    private DettaglioOrdineService dettaglioOrdineService;

    @PostMapping
    public DettaglioOrdineDTO addProdottoToOrdine(@RequestBody DettaglioOrdineDTO dettaglioOrdineDTO) {
        return dettaglioOrdineService.addProdottoToOrdine(dettaglioOrdineDTO.getOrdineId(),
                dettaglioOrdineDTO.getProdottoId(), dettaglioOrdineDTO.getQuantita());
    }

    @GetMapping("/{ordineId}/totale")
    public Double calcolaTotaleOrdine(@PathVariable Long ordineId) {
        return dettaglioOrdineService.calcolaTotaleOrdine(ordineId);
    }
}
