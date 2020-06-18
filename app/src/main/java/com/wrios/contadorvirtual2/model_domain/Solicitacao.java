package com.wrios.contadorvirtual2.model_domain;

import java.util.Random;

public class Solicitacao {

    private String setor;
    private UsuarioCliente usuarioCliente;
    private String idsolicitacao;
    private String descricao;
    private Boolean staus;

    public Solicitacao() {
    }

    public Solicitacao(String setor, UsuarioCliente usuarioCliente, String idsolicitacao, String descricao, Boolean staus) {
        this.setor = setor;
        this.usuarioCliente = usuarioCliente;
        this.idsolicitacao = idsolicitacao;
        this.descricao = descricao;
        this.staus = staus;
    }


    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStaus() {
        return staus;
    }

    public void setStaus(Boolean staus) {
        this.staus = staus;
    }
}