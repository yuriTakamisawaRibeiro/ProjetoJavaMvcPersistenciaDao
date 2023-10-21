package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import Pck_Dao.ConexaoMySql;
import Pck_Model.Agenda_04;

public class Agenda_04_Persistencia {

    public void insertAgenda_04(Agenda_04 agenda_04) {
        String procedureCall = "{CALL PROC_INSAGENDA_04(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, agenda_04.getA04_codigo());
            callableStatement.setString(2, agenda_04.getA04_titulo());
            callableStatement.setString(3, agenda_04.getA04_descricao());
            callableStatement.setInt(4, agenda_04.getA04_status_dt_limite());
            callableStatement.setObject(5, agenda_04.getA04_data_limite());
            callableStatement.setString(6, agenda_04.getA04_resultado());
            callableStatement.setDouble(7, agenda_04.getA04_certeza_resultado());
            callableStatement.setDouble(8, agenda_04.getA04_contradicao_resultado());
            callableStatement.setObject(9, agenda_04.getA04_dt_cadastro());
            callableStatement.setObject(10, agenda_04.getA04_dt_ultima_alteracao());
            callableStatement.setInt(11, agenda_04.getA01_codigo());
            callableStatement.setInt(12, agenda_04.getA04_status());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAgenda_04(Agenda_04 agenda_04) {
        String procedureCall = "{CALL PROC_ALTAGENDA_04(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setString(1, agenda_04.getA04_titulo());
            callableStatement.setString(2, agenda_04.getA04_descricao());
            callableStatement.setInt(3, agenda_04.getA04_status_dt_limite());
            callableStatement.setObject(4, agenda_04.getA04_data_limite());
            callableStatement.setString(5, agenda_04.getA04_resultado());
            callableStatement.setDouble(6, agenda_04.getA04_certeza_resultado());
            callableStatement.setDouble(7, agenda_04.getA04_contradicao_resultado());
            callableStatement.setObject(8, agenda_04.getA04_dt_ultima_alteracao());
            callableStatement.setInt(9, agenda_04.getA01_codigo());
            callableStatement.setInt(10, agenda_04.getA04_status());
            callableStatement.setInt(11, agenda_04.getA04_codigo());

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
        Agenda_04 agenda_04 = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a04_codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                agenda_04 = new Agenda_04();
                agenda_04.setA04_codigo(rs.getInt("A04_CODIGO"));
                agenda_04.setA04_titulo(rs.getString("A04_TITULO"));
                agenda_04.setA04_descricao(rs.getString("A04_DESCRICAO"));
                agenda_04.setA04_status_dt_limite(rs.getInt("A04_STATUS_DT_LIMITE"));
                agenda_04.setA04_data_limite(rs.getObject("A04_DATA_LIMITE", LocalDate.class));
                agenda_04.setA04_resultado(rs.getString("A04_RESULTADO"));
                agenda_04.setA04_certeza_resultado(rs.getDouble("A04_CERTEZA_RESULTADO"));
                agenda_04.setA04_contradicao_resultado(rs.getDouble("A04_CONTRADICAO_RESULTADO"));
                agenda_04.setA04_dt_cadastro(rs.getObject("A04_DT_CADASTRO", LocalDate.class));
                agenda_04.setA04_dt_ultima_alteracao(rs.getObject("A04_DT_ULTIMA_ALTERACAO", LocalDate.class));
                agenda_04.setA01_codigo(rs.getInt("A01_CODIGO"));
                agenda_04.setA04_status(rs.getInt("A04_STATUS"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agenda_04;
    }
}
