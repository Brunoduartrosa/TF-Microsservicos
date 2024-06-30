package com.monolitoclean.scaa.domain.entities;

import com.monolitoclean.scaa.domain.repository.StatusAssinatura;

import java.time.LocalDate;

public class AssinaturaModel {
    private long codigo;
    private AplicativoModel aplicativo;
    private ClienteModel cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;


    public AssinaturaModel(long codigo, AplicativoModel aplicativo, ClienteModel cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public AplicativoModel getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(AplicativoModel aplicativo) {
        this.aplicativo = aplicativo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public String getData(){
        return getCodigo() + "," + getAplicativo() + "," + getCliente() + "," + getInicioVigencia() + "," + getFimVigencia() + "," + StatusAssinatura.ATIVA;
    }

}
