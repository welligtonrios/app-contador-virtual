package com.wrios.contadorvirtual2.model_domain;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.wrios.contadorvirtual2.helper.ConfiguracaoFirebase;

public class UsuarioCliente {


    private String id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioCliente(){

    }
    public UsuarioCliente(String id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude //para nao salvar a senha no banco somente na auteticacao
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void salvar(){
        DatabaseReference databaseReference = ConfiguracaoFirebase.getReferenciaFirebaseDatabase();
        DatabaseReference usuarioRef = databaseReference.child("Clientes").child(getId());
        usuarioRef.setValue(this);
    }



}
