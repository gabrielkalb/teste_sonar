package com.tokiomarine.pesquisas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.PublicoAlvo;
import com.tokiomarine.pesquisas.repository.PublicosAlvoRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class PublicosAlvoService {
    @Autowired
    private PublicosAlvoRepository publicoAlvoRepository;
    public List<PublicoAlvo> listarPublicosAlvo(){
        return publicoAlvoRepository.findAllByDeletadoEmIsNull();
    }

    public Boolean criarPublicoAlvo(PublicoAlvo publicoAlvo){
        try {
            publicoAlvoRepository.save(publicoAlvo);
        return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean deletarPublicoAlvo(int id){
        try {
            PublicoAlvo publicoAlvo = publicoAlvoRepository.findById(id).get();
            publicoAlvo.setDeletadoEm(LocalDateTime.now());
            publicoAlvoRepository.save(publicoAlvo);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean atualizarPublicoAlvo(PublicoAlvo publicoAlvo){
        try {
            Optional<PublicoAlvo> original = publicoAlvoRepository.findById(publicoAlvo.getId());

            if(!original.isPresent()){
                return false;
            }

            PublicoAlvo atualizado = original.get();

            atualizado.setNome(publicoAlvo.getNome());
            atualizado.setAtualizadoEm(LocalDateTime.now());
            publicoAlvoRepository.saveAndFlush(atualizado);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
