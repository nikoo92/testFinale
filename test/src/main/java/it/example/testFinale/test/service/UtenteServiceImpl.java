package it.example.testFinale.test.service;

import it.example.testFinale.test.mapstruck.UtenteMapper;
import it.example.testFinale.test.object.dto.UtenteDTO;
import it.example.testFinale.test.object.model.Utente;
import it.example.testFinale.test.repository.UtenteRepository;
import it.example.testFinale.test.service.interfacce.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UtenteServiceImpl implements UtenteService {
    @Autowired
    private UtenteRepository utenteRepository; // Repository per interagire con il database

    @Autowired
    private UtenteMapper utenteMapper; // Mapper per convertire tra entità e DTO

    @Override
    public UtenteDTO saveUtente(UtenteDTO utenteDTO) {

        Utente utente = new Utente();
        utente.setNome(utenteDTO.getNome());
        utente.setEmail(utenteDTO.getEmail());


        utente = utenteRepository.save(utente);


        return utenteMapper.toDto(utente);
    }

    @Override
    public List<UtenteDTO> getAllUtenti() {

        List<Utente> utenti = utenteRepository.findAll();


        return utenti.stream()
                .map(utenteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UtenteDTO getUtenteById(Long id) {

        Optional<Utente> utenteOptional = utenteRepository.findById(id);


        if (utenteOptional.isEmpty()) {
            throw new RuntimeException("Utente non trovato");
        }


        return utenteMapper.toDto(utenteOptional.get());
    }
}
