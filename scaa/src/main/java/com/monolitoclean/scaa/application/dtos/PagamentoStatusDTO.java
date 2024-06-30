package com.monolitoclean.scaa.application.dtos;

import java.time.LocalDateTime;

public record PagamentoStatusDTO(
        String status,
        LocalDateTime data,
        double valorPago
) {
    public static PagamentoStatusDTO fromPagamentoDTO(PagamentoDTO pagamentoDTO, boolean validado) {
        String status;

        if(validado){
            status = "PAGAMENTO_OK";
        } else {
            status = "VALOR_INCORRETO";
        }

        LocalDateTime data = LocalDateTime.of(
                pagamentoDTO.ano(),
                pagamentoDTO.mes(),
                pagamentoDTO.dia(),
                0,
                0
        );

        return new PagamentoStatusDTO(
                status,
                data,
                pagamentoDTO.valorPago()
        );
    }
}
