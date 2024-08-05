package com.tokiomarine.pesquisas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.Disparo;
import com.tokiomarine.pesquisas.dto.DisparoPaginadoResultado;
import com.tokiomarine.pesquisas.repository.DisparoRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DisparoService {
    @Autowired
    private DisparoRepository disparoRepository;
    
    public List<Disparo> criarVariosDisparos(List<Disparo> disparos) {
        return disparoRepository.saveAll(disparos);
    }

    public long countByDeletadoEmIsNull(){
        return disparoRepository.countByDeletadoEmIsNull();
    }

    public DisparoPaginadoResultado findDisparosPaginado(int pagina, int quantidadePagina){
        long total = disparoRepository.countByDeletadoEmIsNull();
        Page<Disparo> disparos = disparoRepository.findAllByDeletadoEmIsNull(PageRequest.of(pagina, quantidadePagina));
        int proximaPagina = pagina++;
        DisparoPaginadoResultado disparoResultado =  new DisparoPaginadoResultado(proximaPagina,total,disparos.toList());
        return disparoResultado;
    }
}
