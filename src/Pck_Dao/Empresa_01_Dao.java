package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Empresa_01_Dao {

    private Connection connection;

    public Empresa_01_Dao() {
        // Inicialize a conexão na construção do DAO
        connection = ConexaoMySql.conectaBD();
    }

    public void criarTabelaEmpresa() {
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. A tabela não pode ser criada.");
            return;
        }

        String createTableSQL = "CREATE TABLE IF NOT EXISTS EMPRESA_01 ("
                + "A01_CODIGO INT(11) AUTO_INCREMENT PRIMARY KEY,"
                + "A01_NOME TEXT,"
                + "A01_DESCRICAO TEXT,"
                + "A01_STATUS TINYINT(1),"
                + "A01_DT_CADASTRO DATE,"
                + "A01_DT_ULTIMA_ALTERACAO DATE)";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
            System.out.println("Tabela 'EMPRESA_01' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'EMPRESA_01': " + e.getMessage());
        }
    }

    public void createProcedureInsEmpresa_01(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_INSEMPRESA_01(IN A01_CODIGO INT, IN A01_NOME TEXT, IN A01_DESCRICAO TEXT, IN A01_STATUS TINYINT, IN A01_DT_CADASTRO DATE, IN A01_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "INSERT INTO EMPRESA_01 (A01_CODIGO, A01_NOME, A01_DESCRICAO, A01_STATUS, A01_DT_CADASTRO, A01_DT_ULTIMA_ALTERACAO) "
                + "VALUES (A01_CODIGO, A01_NOME, A01_DESCRICAO, A01_STATUS, A01_DT_CADASTRO, A01_DT_ULTIMA_ALTERACAO); "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureAltEmpresa_01(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_ALTEMPRESA_01(IN A01_CODIGO INT, IN A01_NOME TEXT, IN A01_DESCRICAO TEXT, IN A01_STATUS TINYINT, IN A01_DT_CADASTRO DATE, IN A01_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "UPDATE EMPRESA_01 "
                + "SET A01_NOME = A01_NOME, A01_DESCRICAO = A01_DESCRICAO, A01_STATUS = A01_STATUS, A01_DT_CADASTRO = A01_DT_CADASTRO, A01_DT_ULTIMA_ALTERACAO = A01_DT_ULTIMA_ALTERACAO "
                + "WHERE A01_CODIGO = A01_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureDelEmpresa_01(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_DELEMPRESA_01(IN A01_CODIGO INT) "
                + "BEGIN "
                + "DELETE FROM EMPRESA_01 WHERE A01_CODIGO = A01_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureSelEmpresa_01(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_SELEMPRESA_01(IN A01_CODIGO INT) "
                + "BEGIN "
                + "SELECT * FROM EMPRESA_01 WHERE A01_CODIGO = A01_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public static void main(String[] args) {
        Empresa_01_Dao dao = new Empresa_01_Dao();
        dao.criarTabelaEmpresa();
        try {
            // Crie as stored procedures
            dao.createProcedureInsEmpresa_01(dao.connection);
            System.out.println("Procedure insert criada");
            dao.createProcedureAltEmpresa_01(dao.connection);
            System.out.println("Procedure alter criada");
            dao.createProcedureSelEmpresa_01(dao.connection);
            System.out.println("Procedure delete criada");
            dao.createProcedureDelEmpresa_01(dao.connection);
            System.out.println("Procedure select criada");

        } catch (SQLException e) {
            System.err.println("Erro ao criar as stored procedures: " + e.getMessage());
        }
    }
}
