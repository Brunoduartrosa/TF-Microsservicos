package com.monolitoclean.scaa.application.usecase.aplicativo;

import com.monolitoclean.scaa.application.dtos.AplicativoDTO;
import com.monolitoclean.scaa.domain.entities.AplicativoModel;
import com.monolitoclean.scaa.domain.services.AplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraAplicativoUC {
    private AplicativoService cadastraAplicativo;

    @Autowired
    public CadastraAplicativoUC(AplicativoService cadastraAplicativo) {
        this.cadastraAplicativo = cadastraAplicativo;
    }

    public AplicativoDTO run(AplicativoModel aplicativoModel) {
        AplicativoModel aplicativo = cadastraAplicativo.registrarAplicativo(aplicativoModel);
        return AplicativoDTO.fromModel(aplicativo);
    }
}
