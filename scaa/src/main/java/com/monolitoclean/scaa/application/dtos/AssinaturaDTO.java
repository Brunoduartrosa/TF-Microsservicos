package com.monolitoclean.scaa.application.dtos;

import com.monolitoclean.scaa.domain.entities.AplicativoModel;
import com.monolitoclean.scaa.domain.entities.AssinaturaModel;
import com.monolitoclean.scaa.domain.entities.ClienteModel;

import java.time.LocalDate;

public record AssinaturaDTO(
        long codigo,
        AplicativoModel aplicativo,
        ClienteModel cliente,
        LocalDate inicioVigencia,
        LocalDate fimVigencia
) {
    public static AssinaturaDTO fromModel(AssinaturaModel assinatura) {
        return new AssinaturaDTO(
                assinatura.getCodigo(),
                assinatura.getAplicativo(),
                assinatura.getCliente(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia()
        );
    }
}
