package com.monolitoclean.scaa;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "asscache")
public interface AssinaturaProxy {

    @GetMapping("/assinaturas/assinvalida/{codass}")
    boolean verificaAssinatura(@PathVariable long codass);
}
