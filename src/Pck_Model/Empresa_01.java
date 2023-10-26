package Pck_Model;

import java.sql.Date;

public class Empresa_01 {

    private int a01_codigo;
    private String a01_nome;
    private String a01_descricao;
    private int a01_status;
    private Date a01_dt_cadastro;
    private Date a01_dt_ultima_alteracao;

    public int getA01_codigo() {
        return a01_codigo;
    }

    public void setA01_codigo(int a01_codigo) {
        this.a01_codigo = a01_codigo;
    }

    public String getA01_nome() {
        return a01_nome;
    }

    public void setA01_nome(String a01_nome) {
        this.a01_nome = a01_nome;
    }

    public String getA01_descricao() {
        return a01_descricao;
    }

    public void setA01_descricao(String a01_descricao) {
        this.a01_descricao = a01_descricao;
    }

    public int getA01_status() {
        return a01_status;
    }

    public void setA01_status(int a01_status) {
        this.a01_status = a01_status;
    }

    public Date getA01_dt_cadastro() {
        return a01_dt_cadastro;
    }

    public void setA01_dt_cadastro(Date a01_dt_cadastro) {
        this.a01_dt_cadastro = a01_dt_cadastro;
    }

    public Date getA01_dt_ultima_alteracao() {
        return a01_dt_ultima_alteracao;
    }

    public void setA01_dt_ultima_alteracao(Date a01_dt_ultima_alteracao) {
        this.a01_dt_ultima_alteracao = a01_dt_ultima_alteracao;
    }

    public Empresa_01() {
    }

    public Empresa_01(int a01_codigo, String a01_nome, String a01_descricao, int a01_status, Date a01_dt_cadastro,
            Date a01_dt_ultima_alteracao) {
        this.a01_codigo = a01_codigo;
        this.a01_nome = a01_nome;
        this.a01_descricao = a01_descricao;
        this.a01_status = a01_status;
        this.a01_dt_cadastro = a01_dt_cadastro;
        this.a01_dt_ultima_alteracao = a01_dt_ultima_alteracao;
    }

}
