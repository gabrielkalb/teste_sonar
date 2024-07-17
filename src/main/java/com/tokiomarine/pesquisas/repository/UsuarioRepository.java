package com.tokiomarine.pesquisas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tokiomarine.pesquisas.dao.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
