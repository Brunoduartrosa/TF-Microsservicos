package com.monolitoclean.scaa.domain.repository;

import com.monolitoclean.scaa.domain.entities.PagamentoModel;

public interface IPagamentoRepository {
   public int quantidadeDePagamentosRegistrados();
   PagamentoModel  registrarPagamento(PagamentoModel pagamentoModel);
}
