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

@Table(name = "PESQUISA_PERGUNTA_RESPOSTA")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaPerguntaResposta {
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
    @JoinColumn(name = "RESPOSTA_ID", nullable = false)
    private Resposta resposta;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new JsonToStringStyle());
    }
}
