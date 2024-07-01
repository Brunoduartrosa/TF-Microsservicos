package com.asscache.asscache;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;


@FeignClient(name = "scaa")
public interface AssinaturaProxy {

    @GetMapping("/servcad/invalidaass/{codass}")
    LocalDate verificaAssinatura(@PathVariable long codass);
}
