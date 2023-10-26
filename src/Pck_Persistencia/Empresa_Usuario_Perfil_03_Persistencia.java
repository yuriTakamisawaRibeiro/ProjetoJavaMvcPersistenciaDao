package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Pck_Dao.ConexaoMySql;
import Pck_Model.Empresa_usuario_perfil_03;

public class Empresa_Usuario_Perfil_03_Persistencia {

    public void insertEmpresaUsuarioPerfil03(Empresa_usuario_perfil_03 oEmpresaUsuarioPerfil03) {
        String procedureCall = "{CALL PROC_INSEMPRESA_USUARIO_PERFIL_03(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, oEmpresaUsuarioPerfil03.getA01_codigo());
            callableStatement.setDate(2, oEmpresaUsuarioPerfil03.getA03_dt_cadastro());
            callableStatement.setDate(3, oEmpresaUsuarioPerfil03.getA03_dt_ultima_alteracao());
            callableStatement.setInt(4, oEmpresaUsuarioPerfil03.getA03_perfil_praviverbem());
            callableStatement.setInt(5, oEmpresaUsuarioPerfil03.getA03_perfil_administrador());
            callableStatement.setInt(6, oEmpresaUsuarioPerfil03.getA03_perfil_chefe());
            callableStatement.setInt(7, oEmpresaUsuarioPerfil03.getA03_perfil_padrao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmpresaUsuarioPerfil03(Empresa_usuario_perfil_03 oEmpresaUsuarioPerfil03) {
        String procedureCall = "{CALL PROC_ALTEMPRESA_USUARIO_PERFIL_03(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, oEmpresaUsuarioPerfil03.getA01_codigo());
            callableStatement.setDate(2, oEmpresaUsuarioPerfil03.getA03_dt_cadastro());
            callableStatement.setDate(3, oEmpresaUsuarioPerfil03.getA03_dt_ultima_alteracao());
            callableStatement.setInt(4, oEmpresaUsuarioPerfil03.getA03_perfil_praviverbem());
            callableStatement.setInt(5, oEmpresaUsuarioPerfil03.getA03_perfil_administrador());
            callableStatement.setInt(6, oEmpresaUsuarioPerfil03.getA03_perfil_chefe());
            callableStatement.setInt(7, oEmpresaUsuarioPerfil03.getA03_perfil_padrao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpresaUsuarioPerfil03(int a02_codigo) {
        String procedureCall = "{CALL PROC_DELEMPRESA_USUARIO_PERFIL_03(?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a02_codigo);

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Empresa_usuario_perfil_03 selectEmpresaUsuarioPerfil03(int a02_codigo) {
        String procedureCall = "{CALL PROC_SELEMPRESA_USUARIO_PERFIL_03(?)}";
        Empresa_usuario_perfil_03 oEmpresaUsuarioPerfil03 = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a02_codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                oEmpresaUsuarioPerfil03 = new Empresa_usuario_perfil_03();
                oEmpresaUsuarioPerfil03.setA01_codigo(rs.getInt("A01_CODIGO"));
                oEmpresaUsuarioPerfil03.setA02_codigo(rs.getInt("A02_CODIGO"));
                oEmpresaUsuarioPerfil03.setA03_dt_cadastro(rs.getDate("A03_DT_CADASTRO"));
                oEmpresaUsuarioPerfil03.setA03_dt_ultima_alteracao(rs.getDate("A03_DT_ULTIMA_ALTERACAO"));
                oEmpresaUsuarioPerfil03.setA03_perfil_praviverbem(rs.getInt("A03_PERFIL_PRAVIVERBEM"));
                oEmpresaUsuarioPerfil03.setA03_perfil_administrador(rs.getInt("A03_PERFIL_ADMINISTRADOR"));
                oEmpresaUsuarioPerfil03.setA03_perfil_chefe(rs.getInt("A03_PERFIL_CHEFE"));
                oEmpresaUsuarioPerfil03.setA03_perfil_padrao(rs.getInt("A03_PERFIL_PADRAO"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oEmpresaUsuarioPerfil03;
    }
}
