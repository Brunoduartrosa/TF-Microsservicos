package com.asscache.asscache.domain.repository;

import com.asscache.asscache.domain.entities.AssinaturaModel;


public interface IAssinaturaRepository {
    AssinaturaModel buscaAssinaturaPorCodigo(long codigoDaAssinatura);
}
