package com.monolitoclean.scaa.controllers.aplicativos;

import com.monolitoclean.scaa.application.dtos.AplicativoDTO;
import com.monolitoclean.scaa.application.usecase.aplicativo.AplicativosCadastradosUC;
import com.monolitoclean.scaa.application.usecase.aplicativo.AtualizaCustoUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {
    private AplicativosCadastradosUC aplicativosCadastrados;
    private AtualizaCustoUC atualizaCusto;

    @Autowired
    public AplicativoController(AplicativosCadastradosUC aplicativosCadastrados,
                                AtualizaCustoUC atualizaCusto) {
        this.aplicativosCadastrados = aplicativosCadastrados;
        this.atualizaCusto = atualizaCusto;
    }

    @GetMapping("")
    public List<AplicativoDTO> aplicativosCadastrados(){
        return aplicativosCadastrados.run();
    }

    @PostMapping("atualizacusto/{idAplicativo}")
    public AplicativoDTO atualizaCusto(@PathVariable(value = "idAplicativo") long idAplicativo, @RequestBody float custoMensal){
        return atualizaCusto.run(idAplicativo, custoMensal);
    }
}
