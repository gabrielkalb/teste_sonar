package com.tokiomarine.pesquisas.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tokiomarine.pesquisas.dao.Pesquisa;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Integer> {

    @Query("select count(*) from Pesquisa p where :date BETWEEN  p.inicioVigencia  AND p.fimVigencia")
    public Long countAndamento(LocalDateTime date);
    
    @Query("select count(*) from Pesquisa p where :date not BETWEEN  p.inicioVigencia  AND p.fimVigencia")
    public Long countIniciar(LocalDateTime date);
}
