package com.monolitoclean.scaa.application.usecase.assinatura;

import com.monolitoclean.scaa.application.dtos.AssinaturaDTO;
import com.monolitoclean.scaa.domain.services.AssinaturaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarAssinaturasDoClienteUC {
    private AssinaturaService assinaturaService;

    public ListarAssinaturasDoClienteUC(AssinaturaService assinaturaService){
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(long codCliente){
        return assinaturaService.listarAssinaturasDoCliente(codCliente).stream()
            .map(a -> AssinaturaDTO.fromModel(a))
            .toList();
    }
}
