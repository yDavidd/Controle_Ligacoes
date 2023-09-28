package com.control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.entities.Ligacao;
import com.control.repository.LigRepository;

@Service
public class LigServico {
    private final LigRepository ligRepository;
    
    @Autowired
    public LigServico(LigRepository ligRepository) {
        this.ligRepository = ligRepository;
    }

    public List<Ligacao> getAllLigacoes() {
        return ligRepository.findAll();
    }

    public Ligacao getLigacaoById(Long id) {
        Optional<Ligacao> ligacao = ligRepository.findById(id);
        return ligacao.orElse(null);
    }

    public Ligacao salvarLigacao(Ligacao ligacao) {
        return ligRepository.save(ligacao);
    }

    public Ligacao updateLigacao(Long id, Ligacao updatedLigacao) {
        Optional<Ligacao> existingLigacao = ligRepository.findById(id);
        if (existingLigacao.isPresent()) {
            updatedLigacao.setId(id);
            return ligRepository.save(updatedLigacao);
        }
        return null;
    }

    public boolean deleteLigacao(Long id) {
        Optional<Ligacao> existingLigacao = ligRepository.findById(id);
        if (existingLigacao.isPresent()) {
            ligRepository.deleteById(id);
            return true;
        }
        return false;
    }
}