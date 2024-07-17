package com.tokiomarine.pesquisas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.Resposta;
import com.tokiomarine.pesquisas.dao.Usuario;
import com.tokiomarine.pesquisas.repository.RespostaRepository;
import com.tokiomarine.pesquisas.repository.UsuarioRepository;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Resposta> listarRespostas(){
        return respostaRepository.findAllByDeletadoEmIsNull();
    }

    public Boolean criarResposta(Resposta resposta){
        try {
            Integer usuarioId = resposta.getUsuario().getId();

            Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("usuario não encontrado"));

            resposta.setUsuario(usuario);

            respostaRepository.save(resposta);
        return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean deletarResposta(int id){
        try {
            Resposta resposta = respostaRepository.findById(id).get();
            resposta.setDeletadoEm(LocalDateTime.now());
            respostaRepository.save(resposta);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean atualizarResposta(Resposta resposta){
        try {
            Optional<Resposta> original = respostaRepository.findById(resposta.getId());

            if(!original.isPresent()){
                return false;
            }

            Resposta atualizado = original.get();

            Usuario usuario = usuarioRepository.findById(resposta.getUsuario().getId()).orElseThrow(() -> new RuntimeException("usuario não encontrado"));

            atualizado.setTipo(resposta.getTipo());
            atualizado.setInicioVigencia(resposta.getInicioVigencia());
            atualizado.setFimVigencia(resposta.getFimVigencia());
            atualizado.setUsuario(usuario);
            atualizado.setAtualizadoEm(LocalDateTime.now());
            respostaRepository.saveAndFlush(atualizado);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
