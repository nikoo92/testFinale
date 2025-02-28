package it.example.testFinale.test.repository;

import it.example.testFinale.test.object.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository <Utente,Long> {
}
