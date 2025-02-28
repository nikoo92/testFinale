package it.example.testFinale.test.object.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdottoDTO {
    private Long id;
    private String nome;
    private Double prezzo;
}
