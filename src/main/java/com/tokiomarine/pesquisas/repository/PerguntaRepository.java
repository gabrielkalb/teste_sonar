package com.tokiomarine.pesquisas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokiomarine.pesquisas.dao.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
        public List<Pergunta> findAllByDeletadoEmIsNull();
}
