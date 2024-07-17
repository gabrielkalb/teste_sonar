package com.tokiomarine.pesquisas.dao;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.tokiomarine.pesquisas.util.JsonToStringStyle;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "STATUS_DISPARO")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusDisparo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CRIADO_EM")
    @Nullable
    private LocalDateTime criadoEm;

    @Column(name = "ATUALIZADO_EM")
    @Nullable
    private LocalDateTime atualizadoEm;
    
    @Column(name = "DELETADO_EM")
    @Nullable
    private LocalDateTime deletadoEm;

    @PrePersist
    protected void onCreate() {
      criadoEm = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new JsonToStringStyle());
    }
}
