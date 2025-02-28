package it.example.testFinale.test.controller;

import it.example.testFinale.test.object.dto.UtenteDTO;
import it.example.testFinale.test.object.model.Utente;
import it.example.testFinale.test.service.interfacce.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping
    public ResponseEntity<UtenteDTO>createUtente(@RequestBody UtenteDTO utenteDTO) {
        return ResponseEntity.ok(utenteService.saveUtente(utenteDTO));
    }

    @GetMapping
    public ResponseEntity<List<UtenteDTO>> getAllUtenti() {
        return ResponseEntity.ok(utenteService.getAllUtenti());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtenteDTO> getUtenteById(@PathVariable Long id) {
        return ResponseEntity.ok(utenteService.getUtenteById(id));
    }
}
