package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import Pck_Dao.ConexaoMySql;
import Pck_Model.Agenda_04;

public class Agenda_04_Persistencia {

    public void insertAgenda_04(Agenda_04 oAgenda_04) {
        String procedureCall = "{CALL PROC_INSAGENDA_04(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; // Remova o parêntese
                                                                                               // extra no final

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, oAgenda_04.getA04_codigo());
            callableStatement.setString(2, oAgenda_04.getA04_titulo());
            callableStatement.setString(3, oAgenda_04.getA04_descricao());
            callableStatement.setInt(4, oAgenda_04.getA04_status_dt_limite());
            callableStatement.setObject(5, oAgenda_04.getA04_data_limite());
            callableStatement.setString(6, oAgenda_04.getA04_resultado());
            callableStatement.setDouble(7, oAgenda_04.getA04_certeza_resultado());
            callableStatement.setDouble(8, oAgenda_04.getA04_contradicao_resultado());
            callableStatement.setObject(9, oAgenda_04.getA04_dt_cadastro());
            callableStatement.setObject(10, oAgenda_04.getA04_dt_ultima_alteracao());
            callableStatement.setInt(11, oAgenda_04.getA01_codigo());
            callableStatement.setInt(12, oAgenda_04.getA04_status());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAgenda_04(Agenda_04 oAgenda_04) {
        String procedureCall = "{CALL PROC_ALTAGENDA_04(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setString(1, oAgenda_04.getA04_titulo());
            callableStatement.setString(2, oAgenda_04.getA04_descricao());
            callableStatement.setInt(3, oAgenda_04.getA04_status_dt_limite());
            callableStatement.setObject(4, oAgenda_04.getA04_data_limite());
            callableStatement.setString(5, oAgenda_04.getA04_resultado());
            callableStatement.setDouble(6, oAgenda_04.getA04_certeza_resultado());
            callableStatement.setDouble(7, oAgenda_04.getA04_contradicao_resultado());
            callableStatement.setObject(8, oAgenda_04.getA04_dt_ultima_alteracao());
            callableStatement.setInt(9, oAgenda_04.getA01_codigo());
            callableStatement.setInt(10, oAgenda_04.getA04_status());
            callableStatement.setInt(11, oAgenda_04.getA04_codigo());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAgenda_04(int a04_codigo) {
        String procedureCall = "{CALL PROC_DELAGENDA_04(?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a04_codigo);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Agenda_04 selectAgenda_04(int a04_codigo) {
        String procedureCall = "{CALL PROC_SELAGENDA_04(?)}";
        Agenda_04 oAgenda_04 = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a04_codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                oAgenda_04 = new Agenda_04();
                oAgenda_04.setA04_codigo(rs.getInt("A04_CODIGO"));
                oAgenda_04.setA04_titulo(rs.getString("A04_TITULO"));
                oAgenda_04.setA04_descricao(rs.getString("A04_DESCRICAO"));
                oAgenda_04.setA04_status_dt_limite(rs.getInt("A04_STATUS_DT_LIMITE"));
                oAgenda_04.setA04_data_limite(rs.getObject("A04_DATA_LIMITE", LocalDate.class));
                oAgenda_04.setA04_resultado(rs.getString("A04_RESULTADO"));
                oAgenda_04.setA04_certeza_resultado(rs.getDouble("A04_CERTEZA_RESULTADO"));
                oAgenda_04.setA04_contradicao_resultado(rs.getDouble("A04_CONTRADICAO_RESULTADO"));
                oAgenda_04.setA04_dt_cadastro(rs.getObject("A04_DT_CADASTRO", LocalDate.class));
                oAgenda_04.setA04_dt_ultima_alteracao(rs.getObject("A04_DT_ULTIMA_ALTERACAO", LocalDate.class));
                oAgenda_04.setA01_codigo(rs.getInt("A01_CODIGO"));
                oAgenda_04.setA04_status(rs.getInt("A04_STATUS"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oAgenda_04;
    }
}
