package com.monolitoclean.scaa.application.usecase.cliente;

import com.monolitoclean.scaa.application.dtos.ClienteDTO;
import com.monolitoclean.scaa.domain.entities.ClienteModel;
import com.monolitoclean.scaa.domain.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraClienteUC {
    private ClienteService cadastraCliente;

    @Autowired
    public CadastraClienteUC(ClienteService cadastraCliente) {
        this.cadastraCliente = cadastraCliente;
    }

    public ClienteDTO run(ClienteModel clienteModel) {
        ClienteModel cliente = cadastraCliente.registrarCliente(clienteModel);
        return ClienteDTO.fromModel(cliente);
    }
}
