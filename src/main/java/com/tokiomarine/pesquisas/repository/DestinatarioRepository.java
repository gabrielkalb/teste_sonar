package com.tokiomarine.pesquisas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokiomarine.pesquisas.dao.Destinatario;

public interface DestinatarioRepository extends JpaRepository<Destinatario, Integer> {
    public List<Destinatario> findAllByDeletadoEmIsNull();
}
