package com.asscache.asscache.domain.service;


import com.asscache.asscache.domain.entities.AssinaturaModel;
import com.asscache.asscache.domain.repository.IAssinaturaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AssinaturaService {
    private IAssinaturaRepository assinaturaRepository;


    public AssinaturaService(IAssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    public boolean verificaAssinatura(long codass) {
        AssinaturaModel assinaturaModel = assinaturaRepository.buscaAssinaturaPorCodigo(codass);
        if(assinaturaModel != null){
            if(assinaturaModel.getFimVigencia().isBefore(LocalDate.now())){
                return true;
            }
        }
        return false;
    }
}
