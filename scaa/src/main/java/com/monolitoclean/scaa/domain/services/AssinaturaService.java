package com.monolitoclean.scaa.domain.services;

import com.monolitoclean.scaa.domain.entities.AssinaturaModel;
import com.monolitoclean.scaa.domain.repository.IAssinaturaRepository;
import com.monolitoclean.scaa.domain.repository.StatusAssinatura;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AssinaturaService {
    private IAssinaturaRepository assinaturaRepository;


    public AssinaturaService(IAssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<AssinaturaModel> listarAssinaturasDoCliente(long codCliente) {
        return assinaturaRepository.listarAssinaturasPorCodCliente(codCliente);
    }

    public boolean verificaAssinatura(long codass) {
        AssinaturaModel assinaturaModel = assinaturaRepository.buscaAssinaturaPorCodigo(codass);
        if(assinaturaModel != null){
            assinaturaRepository.atualizaAssinatura(assinaturaModel, assinaturaModel.getFimVigencia());
            return true;
        }
        return false;
    }

    public AssinaturaModel registraAssinatura(long codcli, long codapp) {
        return assinaturaRepository.registrarAssinatura(codcli, codapp);
    }


    public List<AssinaturaModel> listarAssinaturasPorStatus(String statusAssinaturaString) {
        String regex = "(?i)ativa";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(statusAssinaturaString);
        StatusAssinatura statusAssinatura;

        if (matcher.find()){
            statusAssinatura = StatusAssinatura.ATIVA;
        } else {
            statusAssinatura = StatusAssinatura.CANCELADA;
        }

        LocalDate dataAtual = LocalDate.now();
        List<AssinaturaModel> assinaturasAux = assinaturaRepository.listarAssinaturas();
        List<AssinaturaModel> result = new ArrayList<>();

        for (AssinaturaModel assinaturaModel : assinaturasAux) {
            boolean isAtiva = assinaturaModel.getFimVigencia().isAfter(dataAtual);
            boolean isCancelada = assinaturaModel.getFimVigencia().isBefore(dataAtual);

            if (statusAssinatura == StatusAssinatura.ATIVA && isAtiva) {
                result.add(assinaturaModel);
            } else if (statusAssinatura == StatusAssinatura.CANCELADA && isCancelada) {
                result.add(assinaturaModel);
            }
        }

        return result;
    }

    public List<AssinaturaModel> listarAssinaturasPorCodAplicativo(long codigoDoAplicativo){
        return assinaturaRepository.listarAssinaturasPorCodAplicativo(codigoDoAplicativo);
    }
}
