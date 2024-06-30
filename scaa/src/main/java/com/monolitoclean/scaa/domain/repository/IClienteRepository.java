package com.monolitoclean.scaa.domain.repository;

import com.monolitoclean.scaa.domain.entities.ClienteModel;

import java.util.List;

public interface IClienteRepository {
    ClienteModel registrarCliente(ClienteModel clienteModel);
    List<ClienteModel> listarClientes();
    ClienteModel buscarClientePorId(long codcli);
}
