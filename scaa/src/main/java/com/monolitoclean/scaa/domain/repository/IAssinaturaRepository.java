package com.monolitoclean.scaa.domain.repository;

import com.monolitoclean.scaa.domain.entities.AssinaturaModel;

import java.time.LocalDate;
import java.util.List;

public interface IAssinaturaRepository {
    AssinaturaModel registrarAssinatura(long codcli, long codapp);
    List<AssinaturaModel> listarAssinaturas();
    List<AssinaturaModel> listarAssinaturasPorCodCliente(long codigoDoCliente);
    List<AssinaturaModel> listarAssinaturasPorCodAplicativo(long codigoDoAplicativo);
    AssinaturaModel buscaAssinaturaPorCodigo(long codass);
    AssinaturaModel atualizaAssinatura(long codass, LocalDate novaData);
    AssinaturaModel atualizaAssinatura(AssinaturaModel assinaturaModel, LocalDate novaData);

}
