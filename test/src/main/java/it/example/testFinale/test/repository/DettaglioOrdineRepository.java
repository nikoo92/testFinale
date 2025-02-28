package it.example.testFinale.test.repository;

import it.example.testFinale.test.object.model.DettaglioOrdine;
import it.example.testFinale.test.object.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DettaglioOrdineRepository extends JpaRepository <DettaglioOrdine,Long>{
    List<DettaglioOrdine> findByOrdine(Ordine ordine);
}
