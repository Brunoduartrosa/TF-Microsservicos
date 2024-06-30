package com.asscache.asscache.controller;


import com.asscache.asscache.application.UC.VerificaAssinaturaUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {


    private VerificaAssinaturaUC verificaAssinatura;

    @Autowired
    public AssinaturaController(VerificaAssinaturaUC verificaAssinatura) {
        this.verificaAssinatura = verificaAssinatura;
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean verificaAssinatura(@PathVariable long codass){
        return verificaAssinatura.run(codass);
    }
}
