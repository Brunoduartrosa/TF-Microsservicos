package com.monolitoclean.scaa.application.usecase.assinatura;

import com.monolitoclean.scaa.application.dtos.AssinaturaDTO;
import com.monolitoclean.scaa.domain.entities.AssinaturaModel;
import com.monolitoclean.scaa.domain.services.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraAssinaturaUC {
    private AssinaturaService cadastraAssinatura;

    @Autowired
    public CadastraAssinaturaUC(AssinaturaService assinaturaService){
        this.cadastraAssinatura = assinaturaService;
    }

    public AssinaturaDTO run(long codcli, long codapp){
        AssinaturaModel assinatura = cadastraAssinatura.registraAssinatura(codcli, codapp);
        return AssinaturaDTO.fromModel(assinatura);
    }
}
