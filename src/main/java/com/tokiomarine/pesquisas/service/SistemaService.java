package com.tokiomarine.pesquisas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.Sistema;
import com.tokiomarine.pesquisas.repository.SistemaRepository;

@Service
public class SistemaService {
    @Autowired
    private SistemaRepository sistemaRepository;

    public List<Sistema> listarSistemas() {
        return this.sistemaRepository.findAll();
    }
}
