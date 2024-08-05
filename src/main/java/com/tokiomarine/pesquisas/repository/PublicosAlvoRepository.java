package com.tokiomarine.pesquisas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokiomarine.pesquisas.dao.PublicoAlvo;
public interface PublicosAlvoRepository  extends JpaRepository<PublicoAlvo, Integer>{
    public List<PublicoAlvo> findAllByDeletadoEmIsNull();
}
