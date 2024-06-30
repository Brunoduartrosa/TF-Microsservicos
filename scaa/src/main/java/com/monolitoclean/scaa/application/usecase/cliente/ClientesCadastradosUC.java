package com.monolitoclean.scaa.application.usecase.cliente;

import com.monolitoclean.scaa.application.dtos.ClienteDTO;
import com.monolitoclean.scaa.domain.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientesCadastradosUC {
    private ClienteService clienteService;

    @Autowired
    public ClientesCadastradosUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDTO> run() {
        return clienteService.clientesCadastrados().stream()
            .map(c -> ClienteDTO.fromModel(c))
            .toList();
    }
}
