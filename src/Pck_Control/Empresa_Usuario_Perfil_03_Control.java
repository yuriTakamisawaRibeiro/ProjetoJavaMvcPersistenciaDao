package Pck_Control;

import java.sql.SQLException;
import Pck_Model.Empresa_usuario_perfil_03;
import Pck_Persistencia.Empresa_Usuario_Perfil_03_Persistencia;

public class Empresa_Usuario_Perfil_03_Control {

    private Empresa_Usuario_Perfil_03_Persistencia empresaUsuarioPerfil03Persistencia = new Empresa_Usuario_Perfil_03_Persistencia();

    public Empresa_usuario_perfil_03 selecionarEmpresaUsuarioPerfil03(int a02_codigo) throws SQLException {
        return empresaUsuarioPerfil03Persistencia.selectEmpresaUsuarioPerfil03(a02_codigo);
    }

    public void inserirEmpresaUsuarioPerfil03(Empresa_usuario_perfil_03 empresa) throws SQLException {
        empresaUsuarioPerfil03Persistencia.insertEmpresaUsuarioPerfil03(empresa);
    }

    public void alterarEmpresaUsuarioPerfil03(Empresa_usuario_perfil_03 empresa) throws SQLException {
        empresaUsuarioPerfil03Persistencia.updateEmpresaUsuarioPerfil03(empresa);
    }

    public void deletarEmpresaUsuarioPerfil03(int a02_codigo) throws SQLException {
        empresaUsuarioPerfil03Persistencia.deleteEmpresaUsuarioPerfil03(a02_codigo);
    }
}
