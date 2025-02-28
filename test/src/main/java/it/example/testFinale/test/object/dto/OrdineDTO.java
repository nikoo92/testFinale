package it.example.testFinale.test.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdineDTO {
    private Long id;
    private LocalDate data;
    private String stato; // IN_ATTESA, SPEDITO, CONSEGNATO
    private Double totale;
    private UtenteDTO utente;
    private List<DettaglioOrdineDTO> dettagli;
}
