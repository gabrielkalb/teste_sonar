package com.tokiomarine.pesquisas.dto;
import java.util.List;

import com.tokiomarine.pesquisas.dao.Pesquisa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PesquisaPaginadaResultado{
    private int proximaPagina;
    private long total;
    private List<Pesquisa> pesquisas;
}