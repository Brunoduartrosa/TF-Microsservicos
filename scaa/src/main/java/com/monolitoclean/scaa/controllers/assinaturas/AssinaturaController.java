package com.monolitoclean.scaa.controllers.assinaturas;

import com.monolitoclean.scaa.application.dtos.AssinaturaDTO;
import com.monolitoclean.scaa.application.dtos.CodigosDTO;
import com.monolitoclean.scaa.application.usecase.assinatura.*;
import com.monolitoclean.scaa.domain.entities.AssinaturaModel;
import com.monolitoclean.scaa.domain.repository.IAssinaturaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/servcad")
public class AssinaturaController {
    private CadastraAssinaturaUC cadastraAssinatura;
    private AssinaturasPorStatusUC assinaturasPorStatus;
    private ListarAssinaturasDoClienteUC listarAssinaturasDoCliente;
    private ListarAssinaturasDoAppUC listarAssinaturasDoApp;
    private IAssinaturaRepository assinaturaRepository

    @Autowired
    public AssinaturaController(CadastraAssinaturaUC cadastraAssinatura,
                                AssinaturasPorStatusUC assinaturasPorStatus,
                                ListarAssinaturasDoClienteUC listarAssinaturasDoCliente,
                                ListarAssinaturasDoAppUC listarAssinaturasDoApp, IAssinaturaRepository assinaturaRepository) {
        this.cadastraAssinatura = cadastraAssinatura;
        this.assinaturasPorStatus = assinaturasPorStatus;
        this.listarAssinaturasDoCliente = listarAssinaturasDoCliente;
        this.listarAssinaturasDoApp = listarAssinaturasDoApp;
        this.assinaturaRepository = assinaturaRepository;
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

    @GetMapping("/verificadata/{codapp}")
    public LocalDate getDataAssinatura(@PathVariable long codass){
        AssinaturaModel assinaturaModel = assinaturaRepository.buscaAssinaturaPorCodigo(codass);
        if(assinaturaModel == null){
            return null;
        }
        return assinaturaModel.getFimVigencia();
    }
}
