package Pck_Control;

import java.sql.SQLException;
import Pck_Model.Empresa_01;
import Pck_Persistencia.Empresa_01_Persistencia;

public class Empresa_01_Control {

    private Empresa_01_Persistencia empresaPersistencia = new Empresa_01_Persistencia();

    public Empresa_01 selecionarEmpresa(int a01_codigo) throws SQLException {
        return empresaPersistencia.selectEmpresa_01(a01_codigo);
    }

    public void inserirEmpresa(Empresa_01 empresa) throws SQLException {
        empresaPersistencia.insertEmpresa_01(empresa);
    }

    public void alterarEmpresa(Empresa_01 empresa) throws SQLException {
        empresaPersistencia.updateEmpresa_01(empresa);
    }

    public void deletarEmpresa(int a01_codigo) throws SQLException {
        empresaPersistencia.deleteEmpresa_01(a01_codigo);
    }
}
