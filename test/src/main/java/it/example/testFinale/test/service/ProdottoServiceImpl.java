package it.example.testFinale.test.service;

import it.example.testFinale.test.mapstruck.ProdottoMapper;
import it.example.testFinale.test.object.dto.ProdottoDTO;
import it.example.testFinale.test.object.model.Prodotto;
import it.example.testFinale.test.repository.ProdottoRepository;
import it.example.testFinale.test.service.interfacce.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProdottoServiceImpl implements ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private ProdottoMapper prodottoMapper;

    @Override
    public ProdottoDTO saveProdotto(ProdottoDTO prodottoDTO) {

        Prodotto prodotto = prodottoMapper.toEntity(prodottoDTO);


        prodotto = prodottoRepository.save(prodotto);


        return prodottoMapper.toDto(prodotto);
    }

    @Override
    public List<ProdottoDTO> getAllProdotti() {
        List<Prodotto> prodotti = prodottoRepository.findAll();


        return prodotti.stream()
                .map(prodottoMapper::toDto)
                .collect(Collectors.toList());
    }
}
