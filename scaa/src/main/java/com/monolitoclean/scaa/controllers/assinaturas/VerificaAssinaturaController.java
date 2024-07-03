package com.monolitoclean.scaa.controllers.assinaturas;

import com.monolitoclean.scaa.application.usecase.assinatura.VerificaAssinaturaUC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificaAssinaturaController {

private VerificaAssinaturaUC verificaAssinatura;

    public VerificaAssinaturaController(VerificaAssinaturaUC verificaAssinaturaUC) {
        this.verificaAssinatura = verificaAssinaturaUC;
    }

    @GetMapping("/invalidaass/{codass}")
    public boolean verificaAssinatura(@PathVariable long codass){
        return verificaAssinatura.run(codass);
    }
}
