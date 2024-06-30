package com.monolitoclean.scaa.application.usecase.aplicativo;

import com.monolitoclean.scaa.application.dtos.AplicativoDTO;
import com.monolitoclean.scaa.domain.entities.AplicativoModel;
import com.monolitoclean.scaa.domain.services.AplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizaCustoUC {
    private AplicativoService aplicativoService;

    @Autowired
    public AtualizaCustoUC(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public AplicativoDTO run(long idAplicativo, float custoMensal){
        AplicativoModel aplicativo =  aplicativoService.atualizaCusto(idAplicativo, custoMensal);
        return AplicativoDTO.fromModel(aplicativo);
    }
}
