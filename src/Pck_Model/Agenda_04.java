package Pck_Model;

import java.time.LocalDate;

public class Agenda_04 {
    private int a04_codigo;
    private String a04_titulo;
    private String a04_descricao;
    private int a04_status_dt_limite;
    private LocalDate a04_data_limite;
    private String a04_resultado;
    private Double a04_certeza_resultado;
    private Double a04_contradicao_resultado;
    private LocalDate a04_dt_cadastro;
    private LocalDate a04_dt_ultima_alteracao;
    private int a01_codigo;
    private int a04_status;

    public int getA04_codigo() {
        return a04_codigo;
    }

    public void setA04_codigo(int a04_codigo) {
        this.a04_codigo = a04_codigo;
    }

    public String getA04_titulo() {
        return a04_titulo;
    }

    public void setA04_titulo(String a04_titulo) {
        this.a04_titulo = a04_titulo;
    }

    public String getA04_descricao() {
        return a04_descricao;
    }

    public void setA04_descricao(String a04_descricao) {
        this.a04_descricao = a04_descricao;
    }

    public int getA04_status_dt_limite() {
        return a04_status_dt_limite;
    }

    public void setA04_status_dt_limite(int a04_status_dt_limite) {
        this.a04_status_dt_limite = a04_status_dt_limite;
    }

    public LocalDate getA04_data_limite() {
        return a04_data_limite;
    }

    public void setA04_data_limite(LocalDate a04_data_limite) {
        this.a04_data_limite = a04_data_limite;
    }

    public String getA04_resultado() {
        return a04_resultado;
    }

    public void setA04_resultado(String a04_resultado) {
        this.a04_resultado = a04_resultado;
    }

    public Double getA04_certeza_resultado() {
        return a04_certeza_resultado;
    }

    public void setA04_certeza_resultado(Double a04_certeza_resultado) {
        this.a04_certeza_resultado = a04_certeza_resultado;
    }

    public Double getA04_contradicao_resultado() {
        return a04_contradicao_resultado;
    }

    public void setA04_contradicao_resultado(Double a04_contradicao_resultado) {
        this.a04_contradicao_resultado = a04_contradicao_resultado;
    }

    public LocalDate getA04_dt_cadastro() {
        return a04_dt_cadastro;
    }

    public void setA04_dt_cadastro(LocalDate a04_dt_cadastro) {
        this.a04_dt_cadastro = a04_dt_cadastro;
    }

    public LocalDate getA04_dt_ultima_alteracao() {
        return a04_dt_ultima_alteracao;
    }

    public void setA04_dt_ultima_alteracao(LocalDate a04_dt_ultima_alteracao) {
        this.a04_dt_ultima_alteracao = a04_dt_ultima_alteracao;
    }

    public int getA01_codigo() {
        return a01_codigo;
    }

    public void setA01_codigo(int a01_codigo) {
        this.a01_codigo = a01_codigo;
    }

    public int getA04_status() {
        return a04_status;
    }

    public void setA04_status(int a04_status) {
        this.a04_status = a04_status;
    }

    public Agenda_04() {
    }

    public Agenda_04(int a04_codigo, String a04_titulo, String a04_descricao, int a04_status_dt_limite,
            LocalDate a04_data_limite, String a04_resultado, Double a04_certeza_resultado,
            Double a04_contradicao_resultado, LocalDate a04_dt_cadastro, LocalDate a04_dt_ultima_alteracao,
            int a01_codigo, int a04_status) {
        this.a04_codigo = a04_codigo;
        this.a04_titulo = a04_titulo;
        this.a04_descricao = a04_descricao;
        this.a04_status_dt_limite = a04_status_dt_limite;
        this.a04_data_limite = a04_data_limite;
        this.a04_resultado = a04_resultado;
        this.a04_certeza_resultado = a04_certeza_resultado;
        this.a04_contradicao_resultado = a04_contradicao_resultado;
        this.a04_dt_cadastro = a04_dt_cadastro;
        this.a04_dt_ultima_alteracao = a04_dt_ultima_alteracao;
        this.a01_codigo = a01_codigo;
        this.a04_status = a04_status;
    }
}
