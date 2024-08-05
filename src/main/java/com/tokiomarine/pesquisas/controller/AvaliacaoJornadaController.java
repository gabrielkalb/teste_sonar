package com.tokiomarine.pesquisas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.pesquisas.dao.AvaliacaoDeJornada;
import com.tokiomarine.pesquisas.service.AvaliacaoJornadaService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/avaliacao-jornada")
public class AvaliacaoJornadaController {
	
    @Autowired
    private AvaliacaoJornadaService avaliacaojornadaService;


    @GetMapping("/listar-avaliacao-jornadas")
    public ResponseEntity<List<AvaliacaoDeJornada>> listarAvaliacaoJornadas() {
    	log.info("Inicio - Class {} - Method {}", this.getClass().getSimpleName(), new Throwable().getStackTrace()[0].getMethodName());
        return ResponseEntity.ok(this.avaliacaojornadaService.listarAvaliacaoJornadas());
    }

    @PostMapping
    public ResponseEntity<Boolean> criarAvaliacaoJornada(@RequestBody AvaliacaoDeJornada avaliacaojornada) {
        return ResponseEntity.ok(this.avaliacaojornadaService.criarAvaliacaoJornada(avaliacaojornada));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletarAvaliacaoJornada(@RequestBody AvaliacaoDeJornada avaliacaojornada) {
        return ResponseEntity.ok(this.avaliacaojornadaService.deletarAvaliacaoJornada(avaliacaojornada.getId()));
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarAvaliacaoJornada(@RequestBody AvaliacaoDeJornada avaliacaojornada) {
        return ResponseEntity.ok(this.avaliacaojornadaService.atualizarAvaliacaoJornada(avaliacaojornada));
    }
}
    