package com.monolitoclean.scaa.domain.services;

import com.monolitoclean.scaa.domain.entities.AplicativoModel;
import com.monolitoclean.scaa.domain.repository.IAplicativoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicativoService {
    private IAplicativoRepository aplicativoRepository;


    public AplicativoService(IAplicativoRepository aplicativoRepository){
        this.aplicativoRepository = aplicativoRepository;
    }

    public AplicativoModel registrarAplicativo(AplicativoModel aplicativoModel){
        return aplicativoRepository.registrarAplicativo(aplicativoModel);
    }

    public List<AplicativoModel> aplicativosCadastrados(){
        return aplicativoRepository.listarAplicativos();
    }

    public AplicativoModel atualizaCusto(long aplicativoId, float custoMensal) { //CHECAR SE É DOUBLE OU FLOAT
        return aplicativoRepository.atualizarCustoMensal(aplicativoId, custoMensal);
    }
}
