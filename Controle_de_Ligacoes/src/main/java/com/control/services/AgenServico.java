package com.control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.entities.Agenda;
import com.control.repository.AgenRepository;

@Service
public class AgenServico {
    private final AgenRepository agenRepository;
    
    @Autowired
    public AgenServico(AgenRepository agenRepository) {
        this.agenRepository = agenRepository;
    }

    public List<Agenda> getAllAgendas() {
        return agenRepository.findAll();
    }

    public Agenda getAgendaById(Long id) {
        Optional<Agenda> agenda = agenRepository.findById(id);
        return agenda.orElse(null);
    }

    public Agenda salvarAgenda(Agenda agenda) {
        return agenRepository.save(agenda);
    }

    public Agenda updateAgenda(Long id, Agenda updatedAgenda) {
        Optional<Agenda> existingAgenda = agenRepository.findById(id);
        if (existingAgenda.isPresent()) {
            updatedAgenda.setId(id);
            return agenRepository.save(updatedAgenda);
        }
        return null;
    }

    public boolean deleteAgenda(Long id) {
        Optional<Agenda> existingAgenda = agenRepository.findById(id);
        if (existingAgenda.isPresent()) {
            agenRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

