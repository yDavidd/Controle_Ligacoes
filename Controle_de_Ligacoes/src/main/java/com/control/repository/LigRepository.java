package com.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.entities.Ligacao;

@Repository
public interface LigRepository extends JpaRepository<Ligacao, Long> {
    // Métodos personalizados podem ser adicionados aqui
}