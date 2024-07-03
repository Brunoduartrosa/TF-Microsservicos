package com.monolitoclean.scaa.repository;

import com.monolitoclean.scaa.domain.dados.AtualizaAssinatura;
import com.monolitoclean.scaa.domain.entities.AssinaturaModel;
import com.monolitoclean.scaa.domain.repository.IAplicativoRepository;
import com.monolitoclean.scaa.domain.repository.IAssinaturaRepository;
import com.monolitoclean.scaa.domain.repository.IClienteRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AssinaturaMemRepository implements IAssinaturaRepository {
    private final RabbitTemplate rabbitTemplate;
    private List<AssinaturaModel> assinaturas;
    private IAplicativoRepository aplicativoRepository;
    private IClienteRepository clienteRepository;

    public AssinaturaMemRepository(IAplicativoRepository aplicativoRepository, IClienteRepository clienteRepository, RabbitTemplate rabbitTemplate){
        this.assinaturas = new ArrayList<>();
        this.aplicativoRepository = aplicativoRepository;
        this.clienteRepository = clienteRepository;
        registrarAssinatura(1, 111);
        registrarAssinatura(2, 222);
        registrarAssinatura(3, 333);
        registrarAssinatura(4, 444);
        registrarAssinatura(5, 555);
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public AssinaturaModel registrarAssinatura(long codcli, long codapp){
        AssinaturaModel assinaturaModel = new AssinaturaModel(
                assinaturas.size()+1,
                aplicativoRepository.buscarAplicativoPorId(codapp),
                clienteRepository.buscarClientePorId(codcli),
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );
        assinaturas.add(assinaturaModel);
        return assinaturaModel;
    }

    @Override
    public List<AssinaturaModel> listarAssinaturas(){
        return assinaturas;
    }

    @Override
    public List<AssinaturaModel> listarAssinaturasPorCodCliente(long codigoDoCliente){
        List<AssinaturaModel> assinaturasFiltradas = assinaturas.stream()
                .filter(p -> p.getCodigo() == codigoDoCliente)
                .collect(Collectors.toList());
        return assinaturasFiltradas;
    }

    @Override
    public List<AssinaturaModel> listarAssinaturasPorCodAplicativo(long codigoDoAplicativo){
        List<AssinaturaModel> assinaturasFiltradas = assinaturas.stream()
                .filter(p -> p.getAplicativo().getCodigo() == codigoDoAplicativo)
                .collect(Collectors.toList());
        System.out.println(assinaturasFiltradas);
        return assinaturasFiltradas;
    }

    @Override
    public AssinaturaModel buscaAssinaturaPorCodigo(long codigoDaAssinatura){
        for (AssinaturaModel aux:assinaturas) {
            if (aux.getCodigo() == codigoDaAssinatura){
                return aux;
            }
        }
        return null;
    }


    //Inserir convertAndSend
    @Override
    public AssinaturaModel atualizaAssinatura(long codAssinatura, LocalDate novaData) {
        AssinaturaModel assinaturaModel = buscaAssinaturaPorCodigo(codAssinatura);
        assinaturaModel.setFimVigencia(novaData);

        rabbitTemplate.convertAndSend("atualiza-assinatura", "", new AtualizaAssinatura(codAssinatura, novaData));
        return assinaturaModel;
    }
}
