package it.example.testFinale.test.repository;

import it.example.testFinale.test.object.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository <Prodotto,Long> {
}
