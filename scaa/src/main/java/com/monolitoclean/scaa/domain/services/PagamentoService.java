package com.monolitoclean.scaa.domain.services;

import com.monolitoclean.scaa.application.dtos.PagamentoDTO;
import com.monolitoclean.scaa.domain.entities.PagamentoModel;
import com.monolitoclean.scaa.domain.repository.IAssinaturaRepository;
import com.monolitoclean.scaa.domain.repository.IPagamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                assinaturaRepository.atualizaAssinatura(pagamentoDTO.codass(), LocalDate.now().plusDays(30)),
                pagamentoDTO.valorPago(),
                LocalDate.now(),
                "none"
        );
        return pagamentoRepository.registrarPagamento(pagamento);
    }
}
