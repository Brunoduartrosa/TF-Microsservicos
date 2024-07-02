package com.monolitoclean.scaa.controllers.assinaturas;

import com.monolitoclean.scaa.application.dtos.AssinaturaDTO;
import com.monolitoclean.scaa.application.dtos.CodigosDTO;
import com.monolitoclean.scaa.application.usecase.assinatura.*;
import com.monolitoclean.scaa.domain.repository.IAssinaturaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad")
public class AssinaturaController {
    private CadastraAssinaturaUC cadastraAssinatura;
    private AssinaturasPorStatusUC assinaturasPorStatus;
    private ListarAssinaturasDoClienteUC listarAssinaturasDoCliente;
    private ListarAssinaturasDoAppUC listarAssinaturasDoApp;
    private VerificaAssinaturaUC verificaAssinatura;
    private RabbitTemplate rabbitTemplate;
    private IAssinaturaRepository iAssinaturaRepository;

    @Autowired
    public AssinaturaController(CadastraAssinaturaUC cadastraAssinatura,
                                AssinaturasPorStatusUC assinaturasPorStatus,
                                ListarAssinaturasDoClienteUC listarAssinaturasDoCliente,
                                ListarAssinaturasDoAppUC listarAssinaturasDoApp,
                                VerificaAssinaturaUC verificaAssinatura, RabbitTemplate rabbitTemplate, IAssinaturaRepository iAssinaturaRepository) {
        this.cadastraAssinatura = cadastraAssinatura;
        this.assinaturasPorStatus = assinaturasPorStatus;
        this.listarAssinaturasDoCliente = listarAssinaturasDoCliente;
        this.listarAssinaturasDoApp = listarAssinaturasDoApp;
        this.verificaAssinatura = verificaAssinatura;
        this.rabbitTemplate = rabbitTemplate;
        this.iAssinaturaRepository = iAssinaturaRepository;
    }

    @PostMapping("/assinaturas")
    public AssinaturaDTO cadastraAssinatura(@RequestBody CodigosDTO codigosDTO){
        return cadastraAssinatura.run(codigosDTO.getCodcli(), codigosDTO.getCodapp());
    }

    @GetMapping("/assinaturas/{statusAssinaturaString}")
    public List<AssinaturaDTO> assinaturasPorStatus(@PathVariable String statusAssinaturaString){
        return assinaturasPorStatus.run(statusAssinaturaString);
    }

    @GetMapping("/asscli/{codcli}")
    public List<AssinaturaDTO> listarAssinaturasDoCliente(@PathVariable long codcli){
        return listarAssinaturasDoCliente.run(codcli);
    }

    @GetMapping("/assapp/{codapp}")
    public List<AssinaturaDTO> listarAssinaturasDoApp(@PathVariable long codapp){
        return listarAssinaturasDoApp.run(codapp);
    }

    @GetMapping("/invalidaass/{codass}")
    public void verificaAssinatura(@PathVariable long codass){
        rabbitTemplate.convertAndSend("atualiza-assinatura-queue", "", "teste");
    }
}
