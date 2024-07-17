package com.tokiomarine.pesquisas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokiomarine.pesquisas.dao.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Integer> {
         public List<Resposta> findAllByDeletadoEmIsNull();
}
