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

import com.tokiomarine.pesquisas.dao.PublicoAlvo;
import com.tokiomarine.pesquisas.service.PublicosAlvoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/publicos-alvo")
public class PublicosAlvoController {
    @Autowired
    private PublicosAlvoService publicosAlvoService;

    @GetMapping("/listar-publicos-alvo")
    public ResponseEntity<List<PublicoAlvo>> listarPublicosAlvo(){
        return ResponseEntity.ok(this.publicosAlvoService.listarPublicosAlvo());
    }

    @PostMapping
    public ResponseEntity<Boolean> criarPublicoAlvo(@RequestBody PublicoAlvo publicoAlvo) {
        return ResponseEntity.ok(this.publicosAlvoService.criarPublicoAlvo(publicoAlvo));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletarStatusDisparo(@RequestBody PublicoAlvo statusDisparo) {
        return ResponseEntity.ok(this.publicosAlvoService.deletarPublicoAlvo(statusDisparo.getId()));
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarStatusDisparo(@RequestBody PublicoAlvo statusDisparo) {
        return ResponseEntity.ok(this.publicosAlvoService.atualizarPublicoAlvo(statusDisparo));
    }
}