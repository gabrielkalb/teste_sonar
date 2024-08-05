package com.tokiomarine.pesquisas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.Sistema;
import com.tokiomarine.pesquisas.repository.SistemaRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class SistemaService {
    @Autowired
    private SistemaRepository sistemaRepository;

    public List<Sistema> listarSistemas() {
        return this.sistemaRepository.findAll();
    }
}
