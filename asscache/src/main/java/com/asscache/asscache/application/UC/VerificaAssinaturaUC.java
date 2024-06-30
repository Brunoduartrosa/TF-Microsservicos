package com.asscache.asscache.application.UC;


import com.asscache.asscache.domain.service.AssinaturaService;
import org.springframework.stereotype.Component;

@Component
public class VerificaAssinaturaUC {
    private AssinaturaService assinaturaService;

    public VerificaAssinaturaUC(AssinaturaService assinaturaService){
        this.assinaturaService = assinaturaService;
    }

    public boolean run(long codAssinatura){
        return assinaturaService.verificaAssinatura(codAssinatura);
    }
}
