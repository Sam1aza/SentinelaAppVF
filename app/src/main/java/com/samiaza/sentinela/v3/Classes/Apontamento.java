package com.samiaza.sentinela.v3.Classes;


public class Apontamento {

    private String glicose;
    private String pressao;
    private String batimento;
    private String data;
    private String hora;
    private String Observacao;
    private String keyApontamento;
    private String usuario;

    public String getGlicose() {
        return glicose;
    }

    public void setGlicose(String glicose) {
        this.glicose = glicose;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getBatimento() {
        return batimento;
    }

    public void setBatimento(String batimento) {
        this.batimento = batimento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
