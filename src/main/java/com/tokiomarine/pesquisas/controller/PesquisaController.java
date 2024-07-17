package com.tokiomarine.pesquisas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.pesquisas.dto.PesquisaCount;
import com.tokiomarine.pesquisas.dto.PesquisaPaginadaEntrada;
import com.tokiomarine.pesquisas.dto.PesquisaPaginadaResultado;
import com.tokiomarine.pesquisas.dto.ResponsePesquisaEmailsDestinatarios;
import com.tokiomarine.pesquisas.service.PesquisaService;

@RestController
@RequestMapping("/pesquisa")
public class PesquisaController {
    @Autowired
    private PesquisaService pesquisaService;

    @GetMapping("/contar-pesquisas")
    public ResponseEntity<PesquisaCount> contarPesquisas() {
        return ResponseEntity.ok(this.pesquisaService.contarPesquisas());
    }

    @GetMapping("/{id}/emails-destinatarios")
    public ResponseEntity<ResponsePesquisaEmailsDestinatarios> emailsDestinatarios(@PathVariable Long id) {
        return ResponseEntity.ok(this.pesquisaService.emailsDestinatarios(id));
    }
    
    @GetMapping("/listar-pesquisas-paginado")
    public ResponseEntity<PesquisaPaginadaResultado> listarPesquisasPaginada(@RequestBody PesquisaPaginadaEntrada pagina) {
        return ResponseEntity.ok(this.pesquisaService.listarPesquisasPaginadas(pagina.getPagina(),pagina.getQuantidadePagina()));
    }
}
