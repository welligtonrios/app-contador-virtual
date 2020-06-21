package com.wrios.contadorvirtual2.model_domain;

public class UsuarioContador {

    private String nome;
    private String id;
    private String senhaContador;

    public UsuarioContador() {
    }

    public UsuarioContador(String nome, String id, String senha) {
        this.nome = nome;
        this.id = id;
        this.senhaContador = senha;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getsenhaContador() {
        return senhaContador;
    }

    public void setSenhaContador(String senha) {
        this.senhaContador = senha;
    }
}
