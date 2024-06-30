package com.monolitoclean.scaa.repository;

import com.monolitoclean.scaa.domain.entities.PagamentoModel;
import com.monolitoclean.scaa.domain.repository.IPagamentoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PagamentoMemRepository implements IPagamentoRepository {
    private List<PagamentoModel> pagamentos;

    public PagamentoMemRepository(){
        pagamentos = new ArrayList<>();
    }

    public int quantidadeDePagamentosRegistrados(){
        return this.pagamentos.size();
    }

    public PagamentoModel registrarPagamento(PagamentoModel pagamentoModel){
        pagamentos.add(pagamentoModel);
        return pagamentoModel;
    }
}
