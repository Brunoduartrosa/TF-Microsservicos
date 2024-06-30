package com.monolitoclean.scaa.application.usecase.assinatura;

import com.monolitoclean.scaa.application.dtos.AssinaturaDTO;
import com.monolitoclean.scaa.domain.services.AssinaturaService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarAssinaturasDoAppUC {
    private AssinaturaService assinaturaService;

    public ListarAssinaturasDoAppUC(AssinaturaService assinaturaService){
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(long codapp){
        return assinaturaService.listarAssinaturasPorCodAplicativo(codapp).stream()
            .map(a -> AssinaturaDTO.fromModel(a))
            .toList();
    }
}
