package it.example.testFinale.test.controller;

import it.example.testFinale.test.object.dto.OrdineDTO;

import it.example.testFinale.test.service.interfacce.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("ordini")
public class OrdineController {

    @Autowired
    private OrdineService ordineService;

    @PostMapping
    public ResponseEntity<OrdineDTO> createOrdine(@RequestBody OrdineDTO ordineDTO) {
        return ResponseEntity.ok(ordineService.saveOrdine(ordineDTO));
    }

    @GetMapping
    public ResponseEntity<List<OrdineDTO>> getAllOrdini() {
        return ResponseEntity.ok(ordineService.getAllOrdini());
    }

    @PutMapping("/{id}/stato")
    public ResponseEntity<OrdineDTO> updateStatoOrdine(@PathVariable Long id, @RequestBody String stato) {
        return ResponseEntity.ok(ordineService.updateStatoOrdine(id, stato));
    }
}