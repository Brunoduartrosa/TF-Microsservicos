package com.monolitoclean.scaa.domain.repository;

import com.monolitoclean.scaa.domain.entities.AplicativoModel;

import java.util.List;

public interface IAplicativoRepository {
    AplicativoModel registrarAplicativo(AplicativoModel aplicativo);
    List<AplicativoModel> listarAplicativos();
    AplicativoModel atualizarCustoMensal(long aplicativoId, float custoMensal);
    AplicativoModel buscarAplicativoPorId(long codapp);
}
