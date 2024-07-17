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

@Table(name = "PESQUISA_EMAIL")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "CONDICAO_DISPARO")
    private String condicaoDisparo;

    @Column(name = "MENSAGEM_EMAIL")
    private String mensagemEmail;
    
    @Column(name = "MENSAGEM_HTML")
    private String mensagemHTML;

    @ManyToOne
    @JoinColumn(name = "PESQUISA_ID")
    private Pesquisa pesquisa;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new JsonToStringStyle());
    }
}
