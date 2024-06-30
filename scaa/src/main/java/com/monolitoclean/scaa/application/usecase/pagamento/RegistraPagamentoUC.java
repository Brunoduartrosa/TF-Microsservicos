package com.monolitoclean.scaa.application.usecase.pagamento;

import com.monolitoclean.scaa.application.dtos.PagamentoDTO;
import com.monolitoclean.scaa.application.dtos.PagamentoStatusDTO;
import com.monolitoclean.scaa.domain.entities.PagamentoModel;
import com.monolitoclean.scaa.domain.services.PagamentoService;
import org.springframework.stereotype.Component;

@Component
public class RegistraPagamentoUC {
    private PagamentoService pagamentoService;

    public RegistraPagamentoUC(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public PagamentoStatusDTO run(PagamentoDTO pagamentoDTO){
        PagamentoModel pagamento = pagamentoService.registraPagamento(pagamentoDTO);
        return PagamentoStatusDTO.fromPagamentoDTO(
                PagamentoDTO.fromModel(pagamento),
                true
        );
    }
}
