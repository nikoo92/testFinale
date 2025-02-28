package it.example.testFinale.test.object.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DettaglioOrdineDTO {
    private Long id;
    private Integer quantita;
    private Double prezzoTotale;
    private Long ordineId;
    private Long prodottoId;
}
