package com.tokiomarine.pesquisas.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.Pesquisa;
import com.tokiomarine.pesquisas.dto.PesquisaCount;
import com.tokiomarine.pesquisas.dto.PesquisaPaginadaResultado;
import com.tokiomarine.pesquisas.dto.ResponsePesquisaEmailsDestinatarios;
import com.tokiomarine.pesquisas.repository.DisparoRepository;
import com.tokiomarine.pesquisas.repository.PesquisaRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class PesquisaService{
    @Autowired
    private PesquisaRepository pesquisaRepository;

    @Autowired
    private DisparoRepository disparoRepository;

    public PesquisaCount contarPesquisas() {
        LocalDateTime date = LocalDateTime.now();
        PesquisaCount pesquisa = new PesquisaCount();
        pesquisa.setAndamento(pesquisaRepository.countAndamento(date).intValue());
        pesquisa.setIniciar(pesquisaRepository.countIniciar(date).intValue());
        return pesquisa;
    }

    public ResponsePesquisaEmailsDestinatarios emailsDestinatarios(Integer id) {
        return new ResponsePesquisaEmailsDestinatarios(disparoRepository.findEmailsDestinatarios(id));
    }
    
    public Pesquisa buscarPesquisa(Integer id) {
        return pesquisaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pesquisa não encontrada"));
    }
    
    public PesquisaPaginadaResultado listarPesquisasPaginadas(Integer pagina, Integer quantidadePagina){
        long total = pesquisaRepository.count();
        Page<Pesquisa> pesquisas = pesquisaRepository.findAll(PageRequest.of(pagina, quantidadePagina));
        int proximaPagina = pagina++;
        PesquisaPaginadaResultado pesquisaResultado =  new PesquisaPaginadaResultado(proximaPagina,total,pesquisas.toList());
        return pesquisaResultado;
    }
    
}
