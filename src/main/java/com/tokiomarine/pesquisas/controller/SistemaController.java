package com.tokiomarine.pesquisas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.pesquisas.dao.Sistema;
import com.tokiomarine.pesquisas.service.SistemaService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/sistema")
public class SistemaController {
    
    @Autowired
    private SistemaService sistemaService;

    @GetMapping
    public ResponseEntity<List<Sistema>> listarSistemas() {
        return ResponseEntity.ok(this.sistemaService.listarSistemas());
    }

    @PostMapping
    public ResponseEntity<String> postMethodName(@RequestBody String entity) {
      
        throw new RuntimeException();  
    }
    
}
