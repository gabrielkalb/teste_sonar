package com.tokiomarine.pesquisas.dao;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.tokiomarine.pesquisas.util.JsonToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "RESPOSTA_PESQUISA")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaPesquisa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "PESQUISA_PERGUNTA_AVALIACAO_DE_JORNADA_ID", nullable = false)
    private PesquisaPerguntaAvaliacaoDeJornada pesquisaPerguntaAvaliacaoDeJornada;

    @Column(name = "RESPOSTA")
    private Boolean condicaoDisparo;

    @Column(name = "CRIADO_EM")
    private LocalDateTime criadoEm;

    @Column(name = "ATUALIZADO_EM")
    private LocalDateTime atualizadoEm;
    
    @Column(name = "DELETADO_EM")
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
