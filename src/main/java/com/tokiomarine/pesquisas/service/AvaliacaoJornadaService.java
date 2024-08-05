package com.tokiomarine.pesquisas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.pesquisas.dao.AvaliacaoDeJornada;
import com.tokiomarine.pesquisas.dao.Usuario;
import com.tokiomarine.pesquisas.repository.AvaliacaoJornadaRepository;
import com.tokiomarine.pesquisas.repository.UsuarioRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AvaliacaoJornadaService {
    @Autowired
    private AvaliacaoJornadaRepository avaliacaojornadaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<AvaliacaoDeJornada> listarAvaliacaoJornadas(){
        return avaliacaojornadaRepository.findAllByDeletadoEmIsNull();
    }

    public Boolean criarAvaliacaoJornada(AvaliacaoDeJornada avaliacaojornada){
        try {
            Integer usuarioId = avaliacaojornada.getUsuario().getId();

            Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("usuario não encontrado"));

            avaliacaojornada.setUsuario(usuario);

            avaliacaojornadaRepository.save(avaliacaojornada);
        return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean deletarAvaliacaoJornada(int id){
        try {
            AvaliacaoDeJornada avaliacaojornada = avaliacaojornadaRepository.findById(id).get();
            avaliacaojornada.setDeletadoEm(LocalDateTime.now());
            avaliacaojornadaRepository.save(avaliacaojornada);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Boolean atualizarAvaliacaoJornada(AvaliacaoDeJornada avaliacaojornada){
        try {
            Optional<AvaliacaoDeJornada> original = avaliacaojornadaRepository.findById(avaliacaojornada.getId());
            if(!original.isPresent()){
                return false;
            }

            AvaliacaoDeJornada atualizado = original.get();

            Usuario usuario = usuarioRepository.findById(avaliacaojornada.getUsuario().getId()).orElseThrow(() -> new RuntimeException("usuario não encontrado"));

            atualizado.setTipo(avaliacaojornada.getTipo());
            atualizado.setTextoAdicional(avaliacaojornada.getTextoAdicional());
            atualizado.setInicioVigencia(avaliacaojornada.getInicioVigencia());
            atualizado.setFimVigencia(avaliacaojornada.getFimVigencia());
            atualizado.setUsuario(usuario);
            atualizado.setAtualizadoEm(LocalDateTime.now());
            avaliacaojornadaRepository.saveAndFlush(atualizado);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
