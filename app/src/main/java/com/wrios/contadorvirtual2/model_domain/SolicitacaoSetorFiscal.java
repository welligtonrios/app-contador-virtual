package com.wrios.contadorvirtual2.model_domain;

public class SolicitacaoSetorFiscal extends Solicitacao {

    private String declarcaoFaturamento;
    private String dasSimplesNacional;
    private String recalculoImposto;
    private String outros;

    public SolicitacaoSetorFiscal() {
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
}
