package Pck_Model;

import java.time.LocalDate;

public class Empresa_usuario_perfil_03 {
    private int a01_codigo;
    private int a02_codigo;
    private LocalDate a03_dt_cadastro;
    private LocalDate a03_dt_ultima_alteracao;
    private int a03_perfil_praviverbem;
    private int a03_perfil_administrador;
    private int a03_perfil_chefe;
    private int a03_perfil_padrao;

    public int getA01_codigo() {
        return a01_codigo;
    }

    public void setA01_codigo(int a01_codigo) {
        this.a01_codigo = a01_codigo;
    }

    public int getA02_codigo() {
        return a02_codigo;
    }

    public void setA02_codigo(int a02_codigo) {
        this.a02_codigo = a02_codigo;
    }

    public LocalDate getA03_dt_cadastro() {
        return a03_dt_cadastro;
    }

    public void setA03_dt_cadastro(LocalDate a03_dt_cadastro) {
        this.a03_dt_cadastro = a03_dt_cadastro;
    }

    public LocalDate getA03_dt_ultima_alteracao() {
        return a03_dt_ultima_alteracao;
    }

    public void setA03_dt_ultima_alteracao(LocalDate a03_dt_ultima_alteracao) {
        this.a03_dt_ultima_alteracao = a03_dt_ultima_alteracao;
    }

    public int getA03_perfil_praviverbem() {
        return a03_perfil_praviverbem;
    }

    public void setA03_perfil_praviverbem(int a03_perfil_praviverbem) {
        this.a03_perfil_praviverbem = a03_perfil_praviverbem;
    }

    public int getA03_perfil_administrador() {
        return a03_perfil_administrador;
    }

    public void setA03_perfil_administrador(int a03_perfil_administrador) {
        this.a03_perfil_administrador = a03_perfil_administrador;
    }

    public int getA03_perfil_chefe() {
        return a03_perfil_chefe;
    }

    public void setA03_perfil_chefe(int a03_perfil_chefe) {
        this.a03_perfil_chefe = a03_perfil_chefe;
    }

    public int getA03_perfil_padrao() {
        return a03_perfil_padrao;
    }

    public void setA03_perfil_padrao(int a03_perfil_padrao) {
        this.a03_perfil_padrao = a03_perfil_padrao;
    }

    public Empresa_usuario_perfil_03() {
    }

    public Empresa_usuario_perfil_03(int a01_codigo, int a02_codigo, LocalDate a03_dt_cadastro,
            LocalDate a03_dt_ultima_alteracao, int a03_perfil_praviverbem, int a03_perfil_administrador,
            int a03_perfil_chefe, int a03_perfil_padrao) {
        this.a01_codigo = a01_codigo;
        this.a02_codigo = a02_codigo;
        this.a03_dt_cadastro = a03_dt_cadastro;
        this.a03_dt_ultima_alteracao = a03_dt_ultima_alteracao;
        this.a03_perfil_praviverbem = a03_perfil_praviverbem;
        this.a03_perfil_administrador = a03_perfil_administrador;
        this.a03_perfil_chefe = a03_perfil_chefe;
        this.a03_perfil_padrao = a03_perfil_padrao;
    }

}
