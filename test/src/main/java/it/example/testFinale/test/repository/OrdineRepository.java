package it.example.testFinale.test.repository;

import it.example.testFinale.test.object.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository <Ordine,Long>{
}
