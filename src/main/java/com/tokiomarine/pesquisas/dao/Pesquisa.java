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

@Table(name = "PESQUISA")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pesquisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SLUG")
    private String slug;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "REENVIO")
    private boolean reenvio;

    @Column(name = "QUANTIDADE_REENVIO")
    private Integer quantidadeReenvio;

    @Column(name = "PERIODICIDADE_REENVIO")
    private Integer periodicidadeReenvio;

    @Column(name = "COMENTARIO_RANGE_NOTA")
    private boolean comentárioRangeNota;
    
    @Column(name = "RANGE_INICIAL")
    private Integer rangeInicial;

    @Column(name = "RANGE_FINAL")
    private Integer rangeFinal;

    @Column(name = "EMAIL_TI")
    private String emailTi;

    @Column(name = "EMAIL_NEGOCIO")
    private String emailNegocio;

    @Column(name = "INICIO_VIGENCIA")
    private LocalDateTime inicioVigencia; 

    @Column(name = "FIM_VIGENCIA")
    private LocalDateTime  fimVigencia; 

    @ManyToOne
    @JoinColumn(name = "TIPO_PESQUISA_ID", nullable = false)
    private TipoPesquisa tipoPesquisa;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "SISTEMA_ID", nullable = false)
    private Sistema sistema;

    @ManyToOne
    @JoinColumn(name = "PROCESSO_ID", nullable = false)
    private Processo processo;

    @ManyToOne
    @JoinColumn(name = "PARAMETRO_ID", nullable = false)
    private Parametro parametro;

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
