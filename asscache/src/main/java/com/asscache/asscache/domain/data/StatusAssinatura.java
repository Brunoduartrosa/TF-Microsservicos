package com.asscache.asscache.domain.data;

import com.asscache.asscache.AssinaturaProxy;
import com.asscache.asscache.domain.entities.AssinaturaModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class StatusAssinatura {

    private final AssinaturaProxy assinaturaProxy;
    private final List<AssinaturaModel> assinaturas = new ArrayList<>();

    public StatusAssinatura(AssinaturaProxy assinaturaProxy) {
        this.assinaturaProxy = assinaturaProxy;
    }

    public LocalDate verificaFimAssinatura(long codass) {
        return assinaturas.stream()
                .filter(ass -> ass.getCodigo() ==codass)
                .map(AssinaturaModel::getFimVigencia)
                .findFirst()
                .orElseGet(() -> {
                    LocalDate fimVigencia = assinaturaProxy.verificaAssinatura(codass);
                    assinaturas.add(new AssinaturaModel(codass, fimVigencia));
                    return fimVigencia;
                });
    }
    public void atualizaStatusAssinatura(long codass, LocalDate novoFimVigencia) {
        assinaturas.stream()
                .filter(ass -> ass.getCodigo() == codass)
                .findFirst()
                .ifPresent(ass -> ass.setFimVigencia(novoFimVigencia));
    }
}

