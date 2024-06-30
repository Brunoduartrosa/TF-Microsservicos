package com.monolitoclean.scaa.domain.repository;

import com.monolitoclean.scaa.domain.entities.AssinaturaModel;

import java.util.List;

public interface IAssinaturaRepository {
    AssinaturaModel registrarAssinatura(long codcli, long codapp);
    List<AssinaturaModel> listarAssinaturas();
    List<AssinaturaModel> listarAssinaturasPorCodCliente(long codigoDoCliente);
    List<AssinaturaModel> listarAssinaturasPorCodAplicativo(long codigoDoAplicativo);
    AssinaturaModel buscaAssinaturaPorCodigo(long codigoDaAssinatura);
}