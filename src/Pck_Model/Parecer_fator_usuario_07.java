package Pck_Model;

import java.time.LocalDate;

public class Parecer_fator_usuario_07 {
    private int a07_codigo;
    private int a06_codigo;
    private int a02_codigo;
    private int a07_num_sequencia;
    private Double a07_certeza;
    private Double a07_contradicao;
    private LocalDate a07_dt_cadastro;
    private LocalDate a07_dt_ultima_alteracao;

    public int getA07_codigo() {
        return a07_codigo;
    }

    public void setA07_codigo(int a07_codigo) {
        this.a07_codigo = a07_codigo;
    }

    public int getA06_codigo() {
        return a06_codigo;
    }

    public void setA06_codigo(int a06_codigo) {
        this.a06_codigo = a06_codigo;
    }

    public int getA02_codigo() {
        return a02_codigo;
    }

    public void setA02_codigo(int a02_codigo) {
        this.a02_codigo = a02_codigo;
    }

    public int getA07_num_sequencia() {
        return a07_num_sequencia;
    }

    public void setA07_num_sequencia(int a07_num_sequencia) {
        this.a07_num_sequencia = a07_num_sequencia;
    }

    public Double getA07_certeza() {
        return a07_certeza;
    }

    public void setA07_certeza(Double a07_certeza) {
        this.a07_certeza = a07_certeza;
    }

    public Double getA07_contradicao() {
        return a07_contradicao;
    }

    public void setA07_contradicao(Double a07_contradicao) {
        this.a07_contradicao = a07_contradicao;
    }

    public LocalDate getA07_dt_cadastro() {
        return a07_dt_cadastro;
    }

    public void setA07_dt_cadastro(LocalDate a07_dt_cadastro) {
        this.a07_dt_cadastro = a07_dt_cadastro;
    }

    public LocalDate getA07_dt_ultima_alteracao() {
        return a07_dt_ultima_alteracao;
    }

    public void setA07_dt_ultima_alteracao(LocalDate a07_dt_ultima_alteracao) {
        this.a07_dt_ultima_alteracao = a07_dt_ultima_alteracao;
    }

    public Parecer_fator_usuario_07() {
    }

    public Parecer_fator_usuario_07(int a07_codigo, int a06_codigo, int a02_codigo, int a07_num_sequencia,
            Double a07_certeza, Double a07_contradicao, LocalDate a07_dt_cadastro, LocalDate a07_dt_ultima_alteracao) {
        this.a07_codigo = a07_codigo;
        this.a06_codigo = a06_codigo;
        this.a02_codigo = a02_codigo;
        this.a07_num_sequencia = a07_num_sequencia;
        this.a07_certeza = a07_certeza;
        this.a07_contradicao = a07_contradicao;
        this.a07_dt_cadastro = a07_dt_cadastro;
        this.a07_dt_ultima_alteracao = a07_dt_ultima_alteracao;
    }

}
