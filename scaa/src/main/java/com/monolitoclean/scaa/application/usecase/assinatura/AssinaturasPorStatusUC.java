package com.monolitoclean.scaa.application.usecase.assinatura;

import com.monolitoclean.scaa.application.dtos.AssinaturaDTO;
import com.monolitoclean.scaa.domain.entities.AssinaturaModel;
import com.monolitoclean.scaa.domain.services.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssinaturasPorStatusUC {
    private AssinaturaService assinaturaService;

    @Autowired
    public AssinaturasPorStatusUC(AssinaturaService assinaturaService){
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(String statusAssinaturaString){
        List<AssinaturaModel> listaDeAssinaturas = assinaturaService.listarAssinaturasPorStatus(statusAssinaturaString);
        return listaDeAssinaturas.stream()
            .map(a->AssinaturaDTO.fromModel(a))
            .toList();
    }
}
