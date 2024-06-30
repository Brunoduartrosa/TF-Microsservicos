package com.monolitoclean.scaa.application.dtos;

import com.monolitoclean.scaa.domain.entities.ClienteModel;

public record ClienteDTO(
        long codigo,
        String nome,
        String email
) {
    public static ClienteDTO fromModel(ClienteModel cliente) {
        return new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
}
