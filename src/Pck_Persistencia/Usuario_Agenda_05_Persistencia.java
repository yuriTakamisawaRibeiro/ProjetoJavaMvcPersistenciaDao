package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Pck_Dao.ConexaoMySql;
import Pck_Model.Usuario_agenda_05;

public class Usuario_Agenda_05_Persistencia {

    public void insertUsuarioAgenda05(Usuario_agenda_05 usuario) {
        String procedureCall = "{CALL PROC_INSAGENDAUSUARIO_05(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, usuario.getA04_codigo());
            callableStatement.setInt(2, usuario.getA02_codigo());
            callableStatement.setInt(3, usuario.getA05_num_sequencia());
            callableStatement.setInt(4, usuario.getA05_perfil_agenda_usuario_titular());
            callableStatement.setInt(5, usuario.getA05_perfil_agenda_facilitador());
            callableStatement.setInt(6, usuario.getA05_perfil_agenda_especialista());
            callableStatement.setInt(7, usuario.getA05_perfil_agenda_analista());
            callableStatement.setDate(8, usuario.getA05_dt_cadastro());
            callableStatement.setDate(9, usuario.getA05_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUsuarioAgenda05(Usuario_agenda_05 usuario) {
        String procedureCall = "{CALL PROC_ALTAGENDAUSUARIO_05(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, usuario.getA04_codigo());
            callableStatement.setInt(2, usuario.getA02_codigo());
            callableStatement.setInt(3, usuario.getA05_num_sequencia());
            callableStatement.setInt(4, usuario.getA05_perfil_agenda_usuario_titular());
            callableStatement.setInt(5, usuario.getA05_perfil_agenda_facilitador());
            callableStatement.setInt(6, usuario.getA05_perfil_agenda_especialista());
            callableStatement.setInt(7, usuario.getA05_perfil_agenda_analista());
            callableStatement.setDate(8, usuario.getA05_dt_cadastro());
            callableStatement.setDate(9, usuario.getA05_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuarioAgenda05(int a05Codigo) {
        String procedureCall = "{CALL PROC_DELAGENDAUSUARIO_05(?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a05Codigo);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario_agenda_05 selectUsuarioAgenda05(int a05Codigo) {
        String procedureCall = "{CALL PROC_SELAGENDAUSUARIO_05(?)}";
        Usuario_agenda_05 usuario = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a05Codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                usuario = new Usuario_agenda_05();
                usuario.setA05_codigo(rs.getInt("A05_CODIGO"));
                usuario.setA04_codigo(rs.getInt("A04_CODIGO"));
                usuario.setA02_codigo(rs.getInt("A02_CODIGO"));
                usuario.setA05_num_sequencia(rs.getInt("A05_NUM_SEQUENCIA"));
                usuario.setA05_perfil_agenda_usuario_titular(rs.getInt("A05_PERFIL_AGENDA_USUARIO_TITULAR"));
                usuario.setA05_perfil_agenda_facilitador(rs.getInt("A05_PERFIL_AGENDA_USUARIO_FACILITADOR"));
                usuario.setA05_perfil_agenda_especialista(rs.getInt("A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA"));
                usuario.setA05_perfil_agenda_analista(rs.getInt("A05_PERFIL_AGENDA_USUARIO_ANALISTA"));
                usuario.setA05_dt_cadastro(rs.getDate("A05_DT_CADASTRO"));
                usuario.setA05_dt_ultima_alteracao(rs.getDate("A05_DT_ULTIMA_ALTERACAO"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
