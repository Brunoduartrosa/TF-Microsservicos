package com.monolitoclean.scaa.domain.services;

import com.monolitoclean.scaa.application.dtos.PagamentoDTO;
import com.monolitoclean.scaa.domain.entities.PagamentoModel;
import com.monolitoclean.scaa.domain.repository.IAssinaturaRepository;
import com.monolitoclean.scaa.domain.repository.IPagamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PagamentoService {
    private IPagamentoRepository pagamentoRepository;
    private IAssinaturaRepository assinaturaRepository;


    public PagamentoService(IPagamentoRepository pagamentoRepository, IAssinaturaRepository assinaturaRepository){
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaRepository = assinaturaRepository;
    }


    public PagamentoModel registraPagamento(PagamentoDTO pagamentoDTO) {
        PagamentoModel pagamento = new PagamentoModel(
                pagamentoRepository.quantidadeDePagamentosRegistrados(),
                assinaturaRepository.buscaAssinaturaPorCodigo(pagamentoDTO.codass()),
                pagamentoDTO.valorPago(),
                LocalDateTime.of(
                        pagamentoDTO.ano(),
                        pagamentoDTO.mes(),
                        pagamentoDTO.dia(),
                        0,
                        0
                ),
                "none"
        );
        return pagamentoRepository.registrarPagamento(pagamento);
    }
}
