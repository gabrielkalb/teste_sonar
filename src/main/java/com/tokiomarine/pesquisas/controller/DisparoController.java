package com.tokiomarine.pesquisas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.pesquisas.dao.Disparo;
import com.tokiomarine.pesquisas.dto.DisparoPaginadoEntrada;
import com.tokiomarine.pesquisas.dto.DisparoPaginadoResultado;
import com.tokiomarine.pesquisas.service.DisparoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/disparo")
public class DisparoController {
    @Autowired
    private DisparoService disparoService;

    @PostMapping("/criar-disparos")
    public ResponseEntity<List<Disparo>> criarVariosDisparos(@RequestBody List<Disparo> disparos) {
        return ResponseEntity.ok(this.disparoService.criarVariosDisparos(disparos));
    }    

    @GetMapping("/listar-disparos-paginado")
    public ResponseEntity<DisparoPaginadoResultado> getMethodName(@RequestBody DisparoPaginadoEntrada disparoPaginadoEntrada) {
        return ResponseEntity.ok(this.disparoService.findDisparosPaginado(disparoPaginadoEntrada.getPagina(), disparoPaginadoEntrada.getQuantidadePagina()));
    }
    
}
