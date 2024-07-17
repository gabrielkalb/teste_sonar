package com.tokiomarine.pesquisas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tokiomarine.pesquisas.dao.Disparo;

public interface DisparoRepository extends JpaRepository<Disparo, Integer> {
    public List<Disparo> findAllByDeletadoEmIsNull();

    @Query("SELECT d.destinatario.email FROM Disparo d WHERE d.pesquisa.id = :pesquisaId")
    public List<String> findEmailsDestinatarios(Long pesquisaId);
    
    public Page<Disparo> findAllByDeletadoEmIsNull(PageRequest pageRequest);

    public long countByDeletadoEmIsNull();
}
