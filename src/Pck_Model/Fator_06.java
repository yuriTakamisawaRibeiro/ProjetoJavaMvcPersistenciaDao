package Pck_Model;

import java.sql.Date;

public class Fator_06 {
    private int a06_codigo;
    private String a06_titulo;
    private String a06_descricao;
    private int a06_num_sequencia;
    private int a04_codigo;
    private Double a06_certeza_resultante_fator;
    private Double a06_contradicao_resultante_fator;
    private Double a06_resultado_fator;
    private Date a06_dt_cadastro;
    private Date a06_dt_ultima_alteracao;
    private int a02_codigo;

    public int getA06_num_sequencia() {
        return a06_num_sequencia;
    }

    public void setA06_num_sequencia(int a06_num_sequencia) {
        this.a06_num_sequencia = a06_num_sequencia;
    }

    public int getA06_codigo() {
        return a06_codigo;
    }

    public void setA06_codigo(int a06_codigo) {
        this.a06_codigo = a06_codigo;
    }

    public String getA06_titulo() {
        return a06_titulo;
    }

    public void setA06_titulo(String a06_titulo) {
        this.a06_titulo = a06_titulo;
    }

    public String getA06_descricao() {
        return a06_descricao;
    }

    public void setA06_descricao(String a06_descricao) {
        this.a06_descricao = a06_descricao;
    }

    public int getA04_codigo() {
        return a04_codigo;
    }

    public void setA04_codigo(int a04_codigo) {
        this.a04_codigo = a04_codigo;
    }

    public Double getA06_certeza_resultante_fator() {
        return a06_certeza_resultante_fator;
    }

    public void setA06_certeza_resultante_fator(Double a06_certeza_resultante_fator) {
        this.a06_certeza_resultante_fator = a06_certeza_resultante_fator;
    }

    public Double getA06_contradicao_resultante_fator() {
        return a06_contradicao_resultante_fator;
    }

    public void setA06_contradicao_resultante_fator(Double a06_contradicao_resultante_fator) {
        this.a06_contradicao_resultante_fator = a06_contradicao_resultante_fator;
    }

    public Double getA06_resultado_fator() {
        return a06_resultado_fator;
    }

    public void setA06_resultado_fator(Double a06_resultado_fator) {
        this.a06_resultado_fator = a06_resultado_fator;
    }

    public Date getA06_dt_cadastro() {
        return a06_dt_cadastro;
    }

    public void setA06_dt_cadastro(Date a06_dt_cadastro) {
        this.a06_dt_cadastro = a06_dt_cadastro;
    }

    public Date getA06_dt_ultima_alteracao() {
        return a06_dt_ultima_alteracao;
    }

    public void setA06_dt_ultima_alteracao(Date a06_dt_ultima_alteracao) {
        this.a06_dt_ultima_alteracao = a06_dt_ultima_alteracao;
    }

    public int getA02_codigo() {
        return a02_codigo;
    }

    public void setA02_codigo(int a02_codigo) {
        this.a02_codigo = a02_codigo;
    }

    public Fator_06() {
    }

    public Fator_06(int a06_codigo, String a06_titulo, String a06_descricao, int a06_num_sequencia, int a04_codigo,
            Double a06_certeza_resultante_fator, Double a06_contradicao_resultante_fator, Double a06_resultado_fator,
            Date a06_dt_cadastro, Date a06_dt_ultima_alteracao, int a02_codigo) {
        this.a06_codigo = a06_codigo;
        this.a06_titulo = a06_titulo;
        this.a06_descricao = a06_descricao;
        this.a06_num_sequencia = a06_num_sequencia;
        this.a04_codigo = a04_codigo;
        this.a06_certeza_resultante_fator = a06_certeza_resultante_fator;
        this.a06_contradicao_resultante_fator = a06_contradicao_resultante_fator;
        this.a06_resultado_fator = a06_resultado_fator;
        this.a06_dt_cadastro = a06_dt_cadastro;
        this.a06_dt_ultima_alteracao = a06_dt_ultima_alteracao;
        this.a02_codigo = a02_codigo;
    }

}
