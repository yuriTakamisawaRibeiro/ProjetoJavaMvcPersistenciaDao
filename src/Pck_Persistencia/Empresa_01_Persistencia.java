package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Pck_Dao.ConexaoMySql;

import Pck_Model.Empresa_01;

public class Empresa_01_Persistencia {

    public void insertEmpresa_01(Empresa_01 empresa) {
        String procedureCall = "{CALL PROC_INSEMPRESA_01(?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, empresa.getA01_codigo());
            callableStatement.setString(2, empresa.getA01_nome());
            callableStatement.setString(3, empresa.getA01_descricao());
            callableStatement.setInt(4, empresa.getA01_status());
            callableStatement.setDate(5, empresa.getA01_dt_cadastro());
            callableStatement.setDate(6, empresa.getA01_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmpresa_01(Empresa_01 empresa) {
        String procedureCall = "{CALL PROC_ALTEMPRESA_01(?, ?, ?, ?, ?, ?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, empresa.getA01_codigo());
            callableStatement.setString(2, empresa.getA01_nome());
            callableStatement.setString(3, empresa.getA01_descricao());
            callableStatement.setInt(4, empresa.getA01_status());
            callableStatement.setDate(5, empresa.getA01_dt_cadastro());
            callableStatement.setDate(6, empresa.getA01_dt_ultima_alteracao());

            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpresa_01(int a01_codigo) {
        String procedureCall = "{CALL PROC_DELEMPRESA_01(?)}";

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a01_codigo);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Empresa_01 selectEmpresa_01(int a01_codigo) {
        String procedureCall = "{CALL PROC_SELEMPRESA_01(?)}";
        Empresa_01 oEmpresa = null;

        try (Connection connection = ConexaoMySql.conectaBD();
                CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

            callableStatement.setInt(1, a01_codigo);
            ResultSet rs = callableStatement.executeQuery();

            if (rs.next()) {
                oEmpresa = new Empresa_01();
                oEmpresa.setA01_codigo(rs.getInt("A01_CODIGO"));
                oEmpresa.setA01_nome(rs.getString("A01_NOME"));
                oEmpresa.setA01_descricao(rs.getString("A01_DESCRICAO"));
                oEmpresa.setA01_status(rs.getInt("A01_STATUS"));
                oEmpresa.setA01_dt_cadastro(rs.getDate("A01_DT_CADASTRO"));
                oEmpresa.setA01_dt_ultima_alteracao(rs.getDate("A01_DT_ULTIMA_ALTERACAO"));

            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oEmpresa;
    }
}
