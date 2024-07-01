package com.asscache.asscache.application.UC;


import com.asscache.asscache.domain.data.StatusAssinatura;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VerificaAssinaturaUC {
private StatusAssinatura statusAssinatura;

    public VerificaAssinaturaUC(StatusAssinatura statusAssinatura){
        this.statusAssinatura = statusAssinatura;
    }

    public boolean verificaAssinaturaStatus(long codass){
        return statusAssinatura.verificaFimAssinatura(codass).isAfter(LocalDate.now());
    }
}
