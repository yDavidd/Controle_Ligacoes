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

import com.control.entities.Ligacao;
import com.control.services.LigServico;

@RestController
@RequestMapping("/ligacao")
public class LigController {
    
    private final LigServico ligServico;
    
    @Autowired
    public LigController(LigServico ligServico) {
        this.ligServico = ligServico;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ligacao> getLigacaoById(@PathVariable Long id) {
        Ligacao ligacao = ligServico.getLigacaoById(id);
        if (ligacao != null) {
            return ResponseEntity.ok(ligacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Ligacao>> getAllLigacoes() {
        List<Ligacao> ligacao= ligServico.getAllLigacoes();
        return ResponseEntity.ok(ligacao);
    }

    @PostMapping("/")
    public ResponseEntity<Ligacao> criarLigacao(@RequestBody Ligacao ligacao) {
        Ligacao criarLigacao = ligServico.salvarLigacao(ligacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarLigacao);
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<Ligacao> updateLigacao(@PathVariable Long id, @RequestBody Ligacao ligacao) {
        Ligacao updatedLigacao = ligServico.updateLigacao(id, ligacao);
        if (updatedLigacao != null) {
            return ResponseEntity.ok(updatedLigacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLigacao(@PathVariable Long id) {
        boolean deleted = ligServico.deleteLigacao(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("A ligação  foi excluída com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
}