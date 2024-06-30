package com.asscache.asscache.domain.repository;

public enum StatusAssinatura {
    ATIVA ("Ativa"),
    CANCELADA ("Cancelada");


    private String nome;

    private StatusAssinatura(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
