package com.tokiomarine.pesquisas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokiomarine.pesquisas.dao.AvaliacaoDeJornada;

public interface AvaliacaoJornadaRepository extends JpaRepository<AvaliacaoDeJornada, Integer> {
    public List<AvaliacaoDeJornada> findAllByDeletadoEmIsNull();
}