package com.tokiomarine.pesquisas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.Pergunta;
import com.tokiomarine.pesquisas.dao.Usuario;
import com.tokiomarine.pesquisas.repository.PerguntaRepository;
import com.tokiomarine.pesquisas.repository.UsuarioRepository;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Pergunta> listarPerguntas(){
        return perguntaRepository.findAllByDeletadoEmIsNull();
    }

    public Boolean criarPergunta(Pergunta pergunta){
        try {
            Integer usuarioId = pergunta.getUsuario().getId();

            Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("usuario não encontrado"));

            pergunta.setUsuario(usuario);

            perguntaRepository.save(pergunta);
        return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean deletarPergunta(int id){
        try {
            Pergunta pergunta = perguntaRepository.findById(id).get();
            pergunta.setDeletadoEm(LocalDateTime.now());
            perguntaRepository.save(pergunta);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean atualizarPergunta(Pergunta pergunta){
        try {
            Optional<Pergunta> original = perguntaRepository.findById(pergunta.getId());
            if(!original.isPresent()){
                return false;
            }

            Pergunta atualizado = original.get();

            Usuario usuario = usuarioRepository.findById(pergunta.getUsuario().getId()).orElseThrow(() -> new RuntimeException("usuario não encontrado"));

            atualizado.setPergunta(pergunta.getPergunta());
            atualizado.setInicioVigencia(pergunta.getInicioVigencia());
            atualizado.setFimVigencia(pergunta.getFimVigencia());
            atualizado.setUsuario(usuario);
            atualizado.setAtualizadoEm(LocalDateTime.now());
            perguntaRepository.saveAndFlush(atualizado);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
