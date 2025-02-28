package it.example.testFinale.test.object.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UtenteDTO {
    private Long id;
    private String nome;
    private String email;
}
