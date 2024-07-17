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

import com.tokiomarine.pesquisas.dao.StatusDisparo;
import com.tokiomarine.pesquisas.service.StatusDisparoService;


@RestController
@RequestMapping("/status-disparo")
public class StatusDisparoController {

    @Autowired
    private StatusDisparoService statusDisparoService;


    @GetMapping("/listar-status-disparo")
    public ResponseEntity<List<StatusDisparo>> listarStatusDisparo() {
        return ResponseEntity.ok(this.statusDisparoService.listarStatusDisparo());
    }

    @PostMapping
    public ResponseEntity<Boolean> criarStatusDisparo(@RequestBody StatusDisparo statusDisparo) {
        return ResponseEntity.ok(this.statusDisparoService.criarStatusDisparo(statusDisparo));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deletarStatusDisparo(@RequestBody StatusDisparo statusDisparo) {
        return ResponseEntity.ok(this.statusDisparoService.deletarStatusDisparo(statusDisparo.getId()));
    }

    @PutMapping
    public ResponseEntity<Boolean> atualizarStatusDisparo(@RequestBody StatusDisparo statusDisparo) {
        return ResponseEntity.ok(this.statusDisparoService.atualizarStatusDisparo(statusDisparo));
    }
}
