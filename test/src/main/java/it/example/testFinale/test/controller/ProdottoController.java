package it.example.testFinale.test.controller;

import it.example.testFinale.test.object.dto.ProdottoDTO;
import it.example.testFinale.test.object.model.Prodotto;
import it.example.testFinale.test.service.interfacce.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @PostMapping
    public ResponseEntity<ProdottoDTO> createProdotto(@RequestBody ProdottoDTO prodottoDTO) {
        return ResponseEntity.ok(prodottoService.saveProdotto(prodottoDTO));
    }


    @GetMapping
    public ResponseEntity <List<ProdottoDTO>> getAllProdotti() {
        return ResponseEntity.ok(prodottoService.getAllProdotti());
    }
}
