package com.tokiomarine.pesquisas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.StatusDisparo;
import com.tokiomarine.pesquisas.repository.StatusDisparoRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class StatusDisparoService {
    @Autowired
    private StatusDisparoRepository statusDisparoRepository;

    public List<StatusDisparo> listarStatusDisparo(){
        return statusDisparoRepository.findAllByDeletadoEmIsNull();
    }

    public Boolean criarStatusDisparo(StatusDisparo statusDisparo){
        try {
        statusDisparoRepository.save(statusDisparo);
        return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean deletarStatusDisparo(int id){
        try {
            StatusDisparo statusDisparo = statusDisparoRepository.findById(id).get();
            statusDisparo.setDeletadoEm(LocalDateTime.now());
            statusDisparoRepository.save(statusDisparo);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean atualizarStatusDisparo(StatusDisparo statusDisparo){
        try {
        Optional<StatusDisparo> original = statusDisparoRepository.findById(statusDisparo.getId());
        if(!original.isPresent()){
            return false;
        }
        StatusDisparo atualizado = original.get();
        atualizado.setNome(statusDisparo.getNome());
        atualizado.setAtualizadoEm(LocalDateTime.now());
        statusDisparoRepository.saveAndFlush(atualizado);
        return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
