package com.control.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.entities.Agenda;
import com.control.services.AgenServico;

@RestController
@RequestMapping("/agenda")
public class AgenController {
    
    private final AgenServico agenServico;
    
    @Autowired
    public AgenController(AgenServico agenServico) {
        this.agenServico = agenServico;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Long id) {
        Agenda agenda = agenServico.getAgendaById(id);
        if (agenda != null) {
            return ResponseEntity.ok(agenda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Agenda>> getAllAgendas() {
        List<Agenda> agenda= agenServico.getAllAgendas();
        return ResponseEntity.ok(agenda);
    }

    @PostMapping("/")
    public ResponseEntity<Agenda> criarAgenda(@RequestBody Agenda agenda) {
        Agenda criarAgenda = agenServico.salvarAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarAgenda);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable Long id, @RequestBody Agenda agenda) {
        Agenda updatedAgenda = agenServico.updateAgenda(id, agenda);
        if (updatedAgenda != null) {
            return ResponseEntity.ok(updatedAgenda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgenda(@PathVariable Long id) {
        boolean deleted = agenServico.deleteAgenda(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("A agenda foi excluída com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
}