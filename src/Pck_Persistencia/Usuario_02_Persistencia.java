package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Pck_Dao.ConexaoMySql;
import Pck_Model.Usuario_02;

public class Usuario_02_Persistencia {

    public void insertUsuario_02(Usuario_02 usuario) {
        String procedureCall = "{CALL PROC_INSUSUARIO_02(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setString(1, usuario.getA02_nome());
            callableStatement.setString(2, usuario.getA02_usuario());
            callableStatement.setString(3, usuario.getA02_senha());
            callableStatement.setString(4, usuario.getA02_codigo_link());
            callableStatement.setString(5, usuario.getA02_email());
            callableStatement.setInt(6, usuario.getA02_status());
            callableStatement.setDate(7, usuario.getA02_dt_cadastro());
            callableStatement.setDate(8, usuario.getA02_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUsuario_02(Usuario_02 oUsuario) {
        String procedureCall = "{CALL PROC_ALTUSUARIO_02(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setString(1, oUsuario.getA02_nome());
            callableStatement.setString(2, oUsuario.getA02_usuario());
            callableStatement.setString(3, oUsuario.getA02_senha());
            callableStatement.setString(4, oUsuario.getA02_codigo_link());
            callableStatement.setString(5, oUsuario.getA02_email());
            callableStatement.setInt(6, oUsuario.getA02_status());
            callableStatement.setDate(7, oUsuario.getA02_dt_cadastro());
            callableStatement.setDate(8, oUsuario.getA02_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario_02(int a02_codigo) {
        String procedureCall = "{CALL PROC_DELUSUARIO_02(?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a02_codigo);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario_02 selectUsuario_02(int a02_codigo) {
        String procedureCall = "{CALL PROC_SELUSUARIO_02(?)}";
        Usuario_02 oUsuario = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a02_codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                oUsuario = new Usuario_02();
                oUsuario.setA02_codigo(rs.getInt("A02_CODIGO"));
                oUsuario.setA02_nome(rs.getString("A02_NOME"));
                oUsuario.setA02_usuario(rs.getString("A02_USUARIO"));
                oUsuario.setA02_senha(rs.getString("A02_SENHA"));
                oUsuario.setA02_codigo_link(rs.getString("A02_CODIGO_LINK"));
                oUsuario.setA02_email(rs.getString("A02_EMAIL"));
                oUsuario.setA02_status(rs.getInt("A02_STATUS"));
                oUsuario.setA02_dt_cadastro(rs.getDate("A02_DT_CADASTRO"));
                oUsuario.setA02_dt_ultima_alteracao(rs.getDate("A02_DT_ULTIMA_ALTERACAO"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oUsuario;
    }
}
