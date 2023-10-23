package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agenda_04_Dao {
    // Atributo para a conexão com o MySQL
    private Connection connection;

    public Agenda_04_Dao() {
        // Inicialize a conexão na construção do DAO
        connection = ConexaoMySql.conectaBD();
    }

    public void criarTabelaAgenda() {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. A tabela não pode ser criada.");
            return;
        }

        // SQL para criar a tabela
        String createTableSQL = "CREATE TABLE IF NOT EXISTS AGENDA_04 ("
                + "A04_CODIGO INT(11) AUTO_INCREMENT PRIMARY KEY,"
                + "A04_TITULO TEXT,"
                + "A04_DESCRICAO TEXT,"
                + "A04_STATUS_DT_LIMITE TINYINT(1),"
                + "A04_DATA_LIMITE DATE,"
                + "A04_RESULTADO TEXT ,"
                + "A04_CERTEZA_RESULTADO DOUBLE,"
                + "A04_CONTRADICAO_RESULTADO DOUBLE,"
                + "A04_DT_CADASTRO DATE,"
                + "A04_DT_ULTIMA_ALTERACAO DATE,"
                + "A01_CODIGO INT(11),"
                + "A04_STATUS INT(3))";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
            System.out.println("Tabela 'AGENDA_04' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'AGENDA_04': " + e.getMessage());
        }
    }

    // Método para criar a stored procedure PROC_INSAGENDA_04 no banco de dados
    public void createProcedureInsAgenda_04(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_INSAGENDA_04(IN A04_CODIGO INT, IN A04_TITULO TEXT, IN A04_DESCRICAO TEXT, IN A04_STATUS_DT_LIMITE TINYINT, IN A04_DATA_LIMITE DATE, IN A04_RESULTADO TEXT, IN A04_CERTEZA_RESULTADO DOUBLE, IN A04_CONTRADICAO_RESULTADO DOUBLE, IN A04_DT_CADASTRO DATE, IN A04_DT_ULTIMA_ALTERACAO DATE, IN A01_CODIGO INT, IN A04_STATUS INT) "
                + "BEGIN "
                + "INSERT INTO AGENDA_04 (A04_CODIGO, A04_TITULO, A04_DESCRICAO, A04_STATUS_DT_LIMITE, A04_DATA_LIMITE, A04_RESULTADO, A04_CERTEZA_RESULTADO, A04_CONTRADICAO_RESULTADO, A04_DT_CADASTRO, A04_DT_ULTIMA_ALTERACAO, A01_CODIGO, A04_STATUS) "
                + "VALUES (A04_CODIGO, A04_TITULO, A04_DESCRICAO, A04_STATUS_DT_LIMITE, A04_DATA_LIMITE, A04_RESULTADO, A04_CERTEZA_RESULTADO, A04_CONTRADICAO_RESULTADO, A04_DT_CADASTRO, A04_DT_ULTIMA_ALTERACAO, A01_CODIGO, A04_STATUS); "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    // Método para criar a stored procedure PROC_ALTAGENDA_04 no banco de dados
    public void createProcedureAltAgenda_04(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_ALTAGENDA_04(IN A04_TITULO TEXT, IN A04_DESCRICAO TEXT, IN A04_STATUS_DT_LIMITE TINYINT, IN A04_DATA_LIMITE DATE, IN A04_RESULTADO TEXT, IN A04_CERTEZA_RESULTADO DOUBLE, IN A04_CONTRADICAO_RESULTADO DOUBLE, IN A04_DT_ULTIMA_ALTERACAO DATE, IN A01_CODIGO INT, IN A04_STATUS INT, IN A04_CODIGO INT) "
                + "BEGIN "
                + "UPDATE AGENDA_04 "
                + "SET A04_TITULO = A04_TITULO, A04_DESCRICAO = A04_DESCRICAO, A04_STATUS_DT_LIMITE = A04_STATUS_DT_LIMITE, A04_DATA_LIMITE = A04_DATA_LIMITE, A04_RESULTADO = A04_RESULTADO, A04_CERTEZA_RESULTADO = A04_CERTEZA_RESULTADO, A04_CONTRADICAO_RESULTADO = A04_CONTRADICAO_RESULTADO, A04_DT_ULTIMA_ALTERACAO = A04_DT_ULTIMA_ALTERACAO, A01_CODIGO = A01_CODIGO, A04_STATUS = A04_STATUS "
                + "WHERE A04_CODIGO = A04_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    // Método para criar a stored procedure PROC_DELAGENDA_04 no banco de dados
    public void createProcedureDelAgenda_04(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_DELAGENDA_04(IN A04_CODIGO INT) "
                + "BEGIN "
                + "DELETE FROM AGENDA_04 WHERE A04_CODIGO = A04_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    // Método para criar a stored procedure PROC_SELAGENDA_04 no banco de dados
    public void createProcedureSelAgenda_04(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_SELAGENDA_04(IN A04_CODIGO INT) "
                + "BEGIN "
                + "SELECT * FROM AGENDA_04 WHERE A04_CODIGO = A04_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public static void main(String[] args) {
        Agenda_04_Dao dao = new Agenda_04_Dao();
        dao.criarTabelaAgenda();
        try {
            // Crie as stored procedures
            dao.createProcedureInsAgenda_04(dao.connection);
            System.out.println("Procedure insert criada");
            dao.createProcedureAltAgenda_04(dao.connection);
            System.out.println("Procedure alter criada");
            dao.createProcedureDelAgenda_04(dao.connection);
            System.out.println("Procedure delete criada");
            dao.createProcedureSelAgenda_04(dao.connection);
            System.out.println("Procedure select criada");

        } catch (SQLException e) {
            System.err.println("Erro ao criar as stored procedures: " + e.getMessage());
        }
    }
}
