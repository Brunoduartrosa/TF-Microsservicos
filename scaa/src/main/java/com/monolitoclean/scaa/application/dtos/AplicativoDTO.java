package com.monolitoclean.scaa.application.dtos;

import com.monolitoclean.scaa.domain.entities.AplicativoModel;

public record AplicativoDTO(long codigo, String nome, double custoMensal) {
    public static AplicativoDTO fromModel(AplicativoModel aplicativo) {
        return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }
}
