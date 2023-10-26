package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Pck_Model.Fator_06;
import Pck_Dao.ConexaoMySql;

public class Fator_06_Persistencia {

    public void insertFator(Fator_06 oFator06) {
        String procedureCall = "{CALL PROC_INSFATOR_06(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setString(1, oFator06.getA06_titulo());
            callableStatement.setString(2, oFator06.getA06_descricao());
            callableStatement.setInt(3, oFator06.getA06_num_sequencia());
            callableStatement.setInt(4, oFator06.getA04_codigo());
            callableStatement.setDouble(5, oFator06.getA06_certeza_resultante_fator());
            callableStatement.setDouble(6, oFator06.getA06_contradicao_resultante_fator());
            callableStatement.setDouble(7, oFator06.getA06_resultado_fator());
            callableStatement.setDate(8, oFator06.getA06_dt_cadastro());
            callableStatement.setDate(9, oFator06.getA06_dt_ultima_alteracao());
            callableStatement.setInt(10, oFator06.getA02_codigo());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFator(Fator_06 oFator06) {
        String procedureCall = "{CALL PROC_ALTFATOR_06(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setString(1, oFator06.getA06_titulo());
            callableStatement.setString(2, oFator06.getA06_descricao());
            callableStatement.setInt(3, oFator06.getA06_num_sequencia());
            callableStatement.setInt(4, oFator06.getA04_codigo());
            callableStatement.setDouble(5, oFator06.getA06_certeza_resultante_fator());
            callableStatement.setDouble(6, oFator06.getA06_contradicao_resultante_fator());
            callableStatement.setDouble(7, oFator06.getA06_resultado_fator());
            callableStatement.setDate(8, oFator06.getA06_dt_cadastro());
            callableStatement.setDate(9, oFator06.getA06_dt_ultima_alteracao());
            callableStatement.setInt(10, oFator06.getA02_codigo());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFator(int a06_codigo) {
        String procedureCall = "{CALL PROC_DELFATOR_06(?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a06_codigo);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Fator_06 selectFator(int a01_codigo) {
        String procedureCall = "{CALL PROC_SELFATOR_06(?)}";
        Fator_06 oFator06 = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a01_codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                oFator06 = new Fator_06();
                oFator06.setA06_codigo(rs.getInt("A06_CODIGO"));
                oFator06.setA06_descricao(rs.getString("A06_DESCRICAO"));
                oFator06.setA06_num_sequencia(rs.getInt("A06_NUM_SEQUENCIA"));
                oFator06.setA04_codigo(rs.getInt("A04_CODIGO"));
                oFator06.setA06_certeza_resultante_fator(rs.getDouble("A06_CERTEZA_RESULTANTE_FATOR"));
                oFator06.setA06_contradicao_resultante_fator(rs.getDouble("A06_CONTRADICAO_RESULTANTE_FATOR"));
                oFator06.setA06_resultado_fator(rs.getDouble("A06_RESULTADO_FATOR"));
                oFator06.setA06_dt_cadastro(rs.getDate("A06_DT_CADASTRO"));
                oFator06.setA06_dt_ultima_alteracao(rs.getDate("A06_DT_ULTIMA_ALTERACAO"));
                oFator06.setA02_codigo(rs.getInt("A02_CODIGO"));

            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oFator06;
    }
}
