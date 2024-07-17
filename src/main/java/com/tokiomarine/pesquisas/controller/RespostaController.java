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

import com.tokiomarine.pesquisas.dao.Resposta;
import com.tokiomarine.pesquisas.service.RespostaService;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    @Autowired
    private RespostaService respostaService;


    @GetMapping("/listar-respostas")
    public ResponseEntity<List<Resposta>> listarRespostas() {
        return ResponseEntity.ok(this.respostaService.listarRespostas());
    }

    @PostMapping
    public ResponseEntity<Boolean> criarResposta(@RequestBody Resposta resposta) {
        return ResponseEntity.ok(this.respostaService.criarResposta(resposta));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletarResposta(@RequestBody Resposta resposta) {
        return ResponseEntity.ok(this.respostaService.deletarResposta(resposta.getId()));
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarResposta(@RequestBody Resposta resposta) {
        return ResponseEntity.ok(this.respostaService.atualizarResposta(resposta));
    }
}
    