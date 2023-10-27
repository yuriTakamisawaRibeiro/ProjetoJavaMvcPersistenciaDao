package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Pck_Dao.ConexaoMySql;
import Pck_Model.Parecer_fator_usuario_07;

public class Parecer_fator_usuario_07_Persistencia {

    public void insertParecerFatorUsuario07(Parecer_fator_usuario_07 parecer) {
        String procedureCall = "{CALL PROC_INSPARECER_FATOR_USUARIO_07(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, parecer.getA06_codigo());
            callableStatement.setInt(2, parecer.getA02_codigo());
            callableStatement.setInt(3, parecer.getA07_num_sequencia());
            callableStatement.setDouble(4, parecer.getA07_certeza());
            callableStatement.setDouble(5, parecer.getA07_contradicao());
            callableStatement.setDate(6, parecer.getA07_dt_cadastro());
            callableStatement.setDate(7, parecer.getA07_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateParecerFatorUsuario07(Parecer_fator_usuario_07 parecer) {
        String procedureCall = "{CALL PROC_ALTPARECER_FATOR_USUARIO_07(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, parecer.getA06_codigo());
            callableStatement.setInt(2, parecer.getA02_codigo());
            callableStatement.setInt(3, parecer.getA07_num_sequencia());
            callableStatement.setDouble(4, parecer.getA07_certeza());
            callableStatement.setDouble(5, parecer.getA07_contradicao());
            callableStatement.setDate(6, parecer.getA07_dt_cadastro());
            callableStatement.setDate(7, parecer.getA07_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteParecerFatorUsuario07(int a07_codigo) {
        String procedureCall = "{CALL PROC_DELPARECER_FATOR_USUARIO_07(?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a07_codigo);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Parecer_fator_usuario_07 selectParecerFatorUsuario07(int a07_codigo) {
        String procedureCall = "{CALL PROC_SELPARECER_FATOR_USUARIO_07(?)}";
        Parecer_fator_usuario_07 parecer = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a07_codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                parecer = new Parecer_fator_usuario_07();
                parecer.setA07_codigo(rs.getInt("A07_CODIGO"));
                parecer.setA06_codigo(rs.getInt("A06_CODIGO"));
                parecer.setA02_codigo(rs.getInt("A02_CODIGO"));
                parecer.setA07_num_sequencia(rs.getInt("A07_NUM_SEQUENCIA"));
                parecer.setA07_certeza(rs.getDouble("A07_CERTEZA"));
                parecer.setA07_contradicao(rs.getDouble("A07_CONTRADICAO"));
                parecer.setA07_dt_cadastro(rs.getDate("A07_DT_CADASTRO"));
                parecer.setA07_dt_ultima_alteracao(rs.getDate("A07_DT_ULTIMA_ALTERACAO"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parecer;
    }
}
