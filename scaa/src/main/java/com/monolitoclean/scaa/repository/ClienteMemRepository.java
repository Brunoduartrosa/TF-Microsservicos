package com.monolitoclean.scaa.repository;

import com.monolitoclean.scaa.domain.entities.ClienteModel;
import com.monolitoclean.scaa.domain.repository.IClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteMemRepository implements IClienteRepository {
    private List<ClienteModel> clientes;

    public ClienteMemRepository() {
        clientes = new ArrayList<>();
        clientes.add(new ClienteModel(1, "João", "joao@hotmail.com"));
        clientes.add(new ClienteModel(2, "Maria", "maria@hotmail.com"));
        clientes.add(new ClienteModel(3, "Rafael", "rafael@hotmail.com"));
        clientes.add(new ClienteModel(4, "José", "jose@hotmail.com"));
        clientes.add(new ClienteModel(5, "Bruno", "bruno@hotmail.com"));
        clientes.add(new ClienteModel(6, "Carlos", "carlos@hotmail.com"));
        clientes.add(new ClienteModel(7, "Eduardo", "eduardo@hotmail.com"));
        clientes.add(new ClienteModel(8, "Eduarda", "eduarda@hotmail.com"));
        clientes.add(new ClienteModel(9, "Rafaela", "rafaela@hotmail.com"));
        clientes.add(new ClienteModel(10, "Mario", "mario@hotmail.com"));
    }

    public ClienteModel registrarCliente(ClienteModel clienteModel){
        clientes.add(clienteModel);
        return clienteModel;
    }

    public ClienteModel buscarClientePorId(long codigoCli){
        for(ClienteModel clienteModel : clientes){
            if (clienteModel.getCodigo() == codigoCli){
                return clienteModel;
            }
        }
        return null;
    }

    public List<ClienteModel> listarClientes(){
        return clientes;
    }
}
