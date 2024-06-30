package com.monolitoclean.scaa.domain.services;

import com.monolitoclean.scaa.domain.entities.ClienteModel;
import com.monolitoclean.scaa.domain.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel registrarCliente(ClienteModel clienteModel){
        return clienteRepository.registrarCliente(clienteModel);
    }


    public List<ClienteModel> clientesCadastrados(){
        return clienteRepository.listarClientes();
    }
}
