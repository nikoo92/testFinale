package it.example.testFinale.test.repository;

import it.example.testFinale.test.object.dto.OrdineDTO;
import it.example.testFinale.test.object.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrdineRepository extends JpaRepository <Ordine,Long>{
    List<Ordine> findByUtenteId(Long utenteId);

    List<Ordine> findByDataBetween(LocalDate startDate, LocalDate endDate);
}
