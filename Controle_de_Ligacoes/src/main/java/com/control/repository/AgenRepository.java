package com.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.control.entities.Agenda;

@Repository
public interface AgenRepository extends JpaRepository<Agenda, Long> {
    // Métodos personalizados podem ser adicionados aqui
}
