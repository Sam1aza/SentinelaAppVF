package com.samiaza.sentinela.v3.Classes;

import java.text.DateFormat;

public class Apontamento {

    private String glicemia;
    private String pressaoArterial;
    private String batimento;
    private String dataApontamento;
    private String horaApontamento;
    private String Observacao;
    private String keyApontamento;
    private String uid;

    public String getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(String glicemia) {
        this.glicemia = glicemia;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getBatimento() {
        return batimento;
    }

    public void setBatimento(String batimento) {
        this.batimento = batimento;
    }

    public String getDataApontamento() {
        return dataApontamento;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setDataApontamento(String dataApontamento) {
        this.dataApontamento = dataApontamento;
    }

    public String getHoraApontamento() {
        return horaApontamento;
    }

    public void setHoraApontamento(String horaApontamento) {
        this.horaApontamento = horaApontamento;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }


    public String getKeyApontamento() {
        return keyApontamento;
    }

    public void setKeyApontamento(String keyApontamento) {
        this.keyApontamento = keyApontamento;
    }


}
