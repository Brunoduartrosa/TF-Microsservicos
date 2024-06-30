package com.monolitoclean.scaa.application.dtos;

public class CodigosDTO {
    private long codcli;
    private long codapp;

    public CodigosDTO(long codcli, long codapp) {
        this.codcli = codcli;
        this.codapp = codapp;
    }
    public long getCodcli() {
        return codcli;
    }

    public void setCodcli(long codcli) {
        this.codcli = codcli;
    }

    public long getCodapp() {
        return codapp;
    }

    public void setCodapp(long codapp) {
        this.codapp = codapp;
    }


}
