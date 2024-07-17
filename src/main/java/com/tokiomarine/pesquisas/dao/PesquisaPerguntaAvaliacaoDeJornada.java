package com.tokiomarine.pesquisas.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.tokiomarine.pesquisas.util.JsonToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "PESQUISA_PERGUNTA_AVALIACAO_DE_JORNADA")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaPerguntaAvaliacaoDeJornada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "PESQUISA_ID", nullable = false)
    private Pesquisa pesquisa;

    @ManyToOne
    @JoinColumn(name = "PERGUNTA_ID", nullable = false)
    private Pergunta pergunta;

    @ManyToOne
    @JoinColumn(name = "AVALIACAO_DE_JORNADA_ID", nullable = false)
    private AvaliacaoDeJornada avaliacaoDeJornada;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new JsonToStringStyle());
    }
}
