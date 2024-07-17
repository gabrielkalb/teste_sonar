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

import com.tokiomarine.pesquisas.dao.Pergunta;
import com.tokiomarine.pesquisas.service.PerguntaService;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
    @Autowired
    private PerguntaService perguntaService;


    @GetMapping("/listar-perguntas")
    public ResponseEntity<List<Pergunta>> listarPerguntas() {
        List<Pergunta> perguntas = this.perguntaService.listarPerguntas();

        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.toString());
        }

        return ResponseEntity.ok(perguntas);
    }

    @PostMapping
    public ResponseEntity<Boolean> criarPergunta(@RequestBody Pergunta pergunta) {
        return ResponseEntity.ok(this.perguntaService.criarPergunta(pergunta));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletarPergunta(@RequestBody Pergunta pergunta) {
        return ResponseEntity.ok(this.perguntaService.deletarPergunta(pergunta.getId()));
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarPergunta(@RequestBody Pergunta pergunta) {
        return ResponseEntity.ok(this.perguntaService.atualizarPergunta(pergunta));
    }
}
    