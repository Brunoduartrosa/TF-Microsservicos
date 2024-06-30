package com.monolitoclean.scaa.repository;

import com.monolitoclean.scaa.domain.entities.AplicativoModel;
import com.monolitoclean.scaa.domain.repository.IAplicativoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AplicativoMemRepository implements IAplicativoRepository {
    private List<AplicativoModel> listaDeAplicativos;

    public AplicativoMemRepository() {
        listaDeAplicativos = new ArrayList<>();
        listaDeAplicativos.add(new AplicativoModel(111, "app1", 100));
        listaDeAplicativos.add(new AplicativoModel(222, "app2", 200));
        listaDeAplicativos.add(new AplicativoModel(333, "app3", 300));
        listaDeAplicativos.add(new AplicativoModel(444, "app4", 400));
        listaDeAplicativos.add(new AplicativoModel(555, "app5", 500));
    }

    public AplicativoModel registrarAplicativo(AplicativoModel aplicativo){
        listaDeAplicativos.add(aplicativo);
        return aplicativo;
    }

    public List<AplicativoModel> listarAplicativos(){
        return listaDeAplicativos;
    }
    
    public AplicativoModel buscarAplicativoPorId(long codapp){
        for (AplicativoModel appModel:listaDeAplicativos) {
            if (appModel.getCodigo() == codapp){
                return appModel;
            }
        }
        return null;
    }

    public AplicativoModel atualizarCustoMensal(long aplicativoId, float custoMensal){
        for(AplicativoModel aplicativo : listaDeAplicativos){
            if(aplicativo.getCodigo() == aplicativoId){
                aplicativo.setCustoMensal(custoMensal);
                return aplicativo;
            }
        }
        return null;
    }

}
