package Pck_Model;

import java.time.LocalDate;

public class Usuario_agenda_05 {
    private int a05_codigo;
    private int a04_codigo;
    private int a02_codigo;
    private int a05_num_sequencia;
    private int a05_perfil_agenda_usuario_titular;
    private int a05_perfil_agenda_facilitador;
    private int a05_perfil_agenda_especialista;
    private int a05_perfil_agenda_analista;
    private LocalDate a05_dt_cadastro;
    private LocalDate a05_dt_ultima_alteracao;

    public int getA05_codigo() {
        return a05_codigo;
    }

    public void setA05_codigo(int a05_codigo) {
        this.a05_codigo = a05_codigo;
    }

    public int getA04_codigo() {
        return a04_codigo;
    }

    public void setA04_codigo(int a04_codigo) {
        this.a04_codigo = a04_codigo;
    }

    public int getA02_codigo() {
        return a02_codigo;
    }

    public void setA02_codigo(int a02_codigo) {
        this.a02_codigo = a02_codigo;
    }

    public int getA05_num_sequencia() {
        return a05_num_sequencia;
    }

    public void setA05_num_sequencia(int a05_num_sequencia) {
        this.a05_num_sequencia = a05_num_sequencia;
    }

    public int getA05_perfil_agenda_usuario_titular() {
        return a05_perfil_agenda_usuario_titular;
    }

    public void setA05_perfil_agenda_usuario_titular(int a05_perfil_agenda_usuario_titular) {
        this.a05_perfil_agenda_usuario_titular = a05_perfil_agenda_usuario_titular;
    }

    public int getA05_perfil_agenda_facilitador() {
        return a05_perfil_agenda_facilitador;
    }

    public void setA05_perfil_agenda_facilitador(int a05_perfil_agenda_facilitador) {
        this.a05_perfil_agenda_facilitador = a05_perfil_agenda_facilitador;
    }

    public int getA05_perfil_agenda_especialista() {
        return a05_perfil_agenda_especialista;
    }

    public void setA05_perfil_agenda_especialista(int a05_perfil_agenda_especialista) {
        this.a05_perfil_agenda_especialista = a05_perfil_agenda_especialista;
    }

    public int getA05_perfil_agenda_analista() {
        return a05_perfil_agenda_analista;
    }

    public void setA05_perfil_agenda_analista(int a05_perfil_agenda_analista) {
        this.a05_perfil_agenda_analista = a05_perfil_agenda_analista;
    }

    public LocalDate getA05_dt_cadastro() {
        return a05_dt_cadastro;
    }

    public void setA05_dt_cadastro(LocalDate a05_dt_cadastro) {
        this.a05_dt_cadastro = a05_dt_cadastro;
    }

    public LocalDate getA05_dt_ultima_alteracao() {
        return a05_dt_ultima_alteracao;
    }

    public void setA05_dt_ultima_alteracao(LocalDate a05_dt_ultima_alteracao) {
        this.a05_dt_ultima_alteracao = a05_dt_ultima_alteracao;
    }

    public Usuario_agenda_05() {
    }

    public Usuario_agenda_05(int a05_codigo, int a04_codigo, int a02_codigo, int a05_num_sequencia,
            int a05_perfil_agenda_usuario_titular, int a05_perfil_agenda_facilitador,
            int a05_perfil_agenda_especialista, int a05_perfil_agenda_analista, LocalDate a05_dt_cadastro,
            LocalDate a05_dt_ultima_alteracao) {
        this.a05_codigo = a05_codigo;
        this.a04_codigo = a04_codigo;
        this.a02_codigo = a02_codigo;
        this.a05_num_sequencia = a05_num_sequencia;
        this.a05_perfil_agenda_usuario_titular = a05_perfil_agenda_usuario_titular;
        this.a05_perfil_agenda_facilitador = a05_perfil_agenda_facilitador;
        this.a05_perfil_agenda_especialista = a05_perfil_agenda_especialista;
        this.a05_perfil_agenda_analista = a05_perfil_agenda_analista;
        this.a05_dt_cadastro = a05_dt_cadastro;
        this.a05_dt_ultima_alteracao = a05_dt_ultima_alteracao;
    }

}
