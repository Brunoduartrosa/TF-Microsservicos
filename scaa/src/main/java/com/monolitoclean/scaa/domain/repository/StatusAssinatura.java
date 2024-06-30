package com.monolitoclean.scaa.domain.repository;

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

//    public String setNome(AssinaturaModel assinaturaModel){
//        LocalDate dataAtual = LocalDate.now();
//        if (assinaturaModel.getFimVigencia().toInstant().isBefore(Instant.from(dataAtual))){
//            nome.equalsIgnoreCase("Ativa");
//        }else {
//            nome.equalsIgnoreCase("Cancelada");
//        }
//
//            return nome;
//    }
}
