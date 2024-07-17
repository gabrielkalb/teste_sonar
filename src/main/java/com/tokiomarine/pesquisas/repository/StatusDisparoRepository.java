package com.tokiomarine.pesquisas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokiomarine.pesquisas.dao.StatusDisparo;

public interface StatusDisparoRepository extends JpaRepository<StatusDisparo, Integer> {

    public List<StatusDisparo> findAllByDeletadoEmIsNull();
}
