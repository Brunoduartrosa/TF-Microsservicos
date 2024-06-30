package com.monolitoclean.scaa.controllers.pagamento;

import com.monolitoclean.scaa.application.dtos.PagamentoDTO;
import com.monolitoclean.scaa.application.dtos.PagamentoStatusDTO;
import com.monolitoclean.scaa.application.usecase.pagamento.RegistraPagamentoUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {
    private RegistraPagamentoUC registraPagamentoUC;

    @Autowired
    public PagamentoController(RegistraPagamentoUC registraPagamentoUC){
        this.registraPagamentoUC = registraPagamentoUC;
    }

    @PostMapping("")
    public PagamentoStatusDTO registraPagamento(@RequestBody PagamentoDTO pagamentoDto){
        return registraPagamentoUC.run(pagamentoDto);
    }
}
