package com.wrios.contadorvirtual2.model_domain;

import com.google.firebase.database.DatabaseReference;
import com.wrios.contadorvirtual2.helper.ConfiguracaoFirebase;

public class SolicitacaoSetorFiscal extends Solicitacao {

    private String declarcaoFaturamento;
    private String dasSimplesNacional;
    private String recalculoImposto;
    private String outros;

    public SolicitacaoSetorFiscal() {
        DatabaseReference solicitacaoRef = ConfiguracaoFirebase.getReferenciaFirebaseDatabase().child("minhas_solicitacoes");//referencia para campo minhas solicitacoes
        this.setIdsolicitacao(solicitacaoRef.push().getKey());//qunado eu criar uma instancia desse objeto vai ser gerado um id

    }

    public SolicitacaoSetorFiscal(String setor, UsuarioCliente usuarioCliente, String idsolicitacao, String descricao, Boolean staus, String declarcaoFaturamento, String dasSimplesNacional, String recalculoImposto, String outros) {
        super(setor, usuarioCliente, idsolicitacao, descricao, staus);
        this.declarcaoFaturamento = declarcaoFaturamento;
        this.dasSimplesNacional = dasSimplesNacional;
        this.recalculoImposto = recalculoImposto;
        this.outros = outros;
    }


    public String getDeclarcaoFaturamento() {
        return declarcaoFaturamento;
    }

    public void setDeclarcaoFaturamento(String declarcaoFaturamento) {
        this.declarcaoFaturamento = declarcaoFaturamento;
    }

    public String getDasSimplesNacional() {
        return dasSimplesNacional;
    }

    public void setDasSimplesNacional(String dasSimplesNacional) {
        this.dasSimplesNacional = dasSimplesNacional;
    }

    public String getRecalculoImposto() {
        return recalculoImposto;
    }

    public void setRecalculoImposto(String recalculoImposto) {
        this.recalculoImposto = recalculoImposto;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public void salvar(){

        String idUsuario = ConfiguracaoFirebase.getIdUsuario();
        DatabaseReference solicitacaoRef = ConfiguracaoFirebase.getReferenciaFirebaseDatabase().
                child("minhas_solicitacoes");//referencia para campo minhas solicitacoes

        solicitacaoRef.child(idUsuario).
        child(getIdsolicitacao()).
        setValue(this);

    }

    //remover solicitacao
    public  void remover(){
        String idUsuario = ConfiguracaoFirebase.getIdUsuario();
        DatabaseReference solicitacaoRef = ConfiguracaoFirebase.getReferenciaFirebaseDatabase().
                //referencia para campo minhas solicitacoes
                child("minhas_solicitacoes")
                .child(idUsuario)
                .child(getIdsolicitacao());

        solicitacaoRef.removeValue();
    }
}
