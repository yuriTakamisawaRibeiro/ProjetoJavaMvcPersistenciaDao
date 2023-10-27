package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fator_06_Dao {
    private Connection connection;

    public Fator_06_Dao() {
        // Inicialize a conexão na construção do DAO
        connection = ConexaoMySql.conectaBD();
    }

    public void criarTabelaFator() {
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. A tabela não pode ser criada.");
            return;
        }

        String createTableSQL = "CREATE TABLE IF NOT EXISTS FATOR_06 ("
                + "A06_CODIGO INT(11) AUTO_INCREMENT PRIMARY KEY,"
                + "A06_TITULO TEXT,"
                + "A06_DESCRICAO TEXT,"
                + "A06_NUM_SEQUENCIA INT(11),"
                + "A04_CODIGO INT(11),"
                + "A06_CERTEZA_RESULTANTE_FATOR DOUBLE,"
                + "A06_CONTRADICAO_RESULTANTE_FATOR DOUBLE,"
                + "A06_RESULTADO_FATOR TEXT,"
                + "A06_DT_CADASTRO DATE,"
                + "A06_DT_ULTIMA_ALTERACAO DATE,"
                + "A02_CODIGO INT(11),"
                + "FOREIGN KEY (A04_CODIGO) REFERENCES AGENDA_04(A04_CODIGO),"
                + "FOREIGN KEY (A02_CODIGO) REFERENCES PARECER_FATOR_USUARIO_07(A02_CODIGO))";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
            System.out.println("Tabela 'FATOR_06' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'FATOR_06': " + e.getMessage());
        }
    }

    public void createProcedureInsFator_06(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_INSFATOR_06(IN A06_TITULO TEXT, IN A06_DESCRICAO TEXT, IN A06_NUM_SEQUENCIA INT, IN A04_CODIGO INT, IN A06_CERTEZA_RESULTANTE_FATOR DOUBLE, IN A06_CONTRADICAO_RESULTANTE_FATOR DOUBLE, IN A06_RESULTADO_FATOR TEXT, IN A06_DT_CADASTRO DATE, IN A06_DT_ULTIMA_ALTERACAO DATE, IN A02_CODIGO INT) "
                + "BEGIN "
                + "INSERT INTO FATOR_06 (A06_TITULO, A06_DESCRICAO, A06_NUM_SEQUENCIA, A04_CODIGO, A06_CERTEZA_RESULTANTE_FATOR, A06_CONTRADICAO_RESULTANTE_FATOR, A06_RESULTADO_FATOR, A06_DT_CADASTRO, A06_DT_ULTIMA_ALTERACAO, A02_CODIGO) "
                + "VALUES (A06_TITULO, A06_DESCRICAO, A06_NUM_SEQUENCIA, A04_CODIGO, A06_CERTEZA_RESULTANTE_FATOR, A06_CONTRADICAO_RESULTANTE_FATOR, A06_RESULTADO_FATOR, A06_DT_CADASTRO, A06_DT_ULTIMA_ALTERACAO, A02_CODIGO); "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureAltFator_06(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_ALTFATOR_06(IN A06_TITULO TEXT, IN A06_DESCRICAO TEXT, IN A06_NUM_SEQUENCIA INT, IN A04_CODIGO INT, IN A06_CERTEZA_RESULTANTE_FATOR DOUBLE,IN A06_CONTRADICAO_RESULTANTE_FATOR DOUBLE, IN A06_RESULTADO_FATOR TEXT, IN A06_DT_CADASTRO DATE, IN A06_DT_ULTIMA_ALTERACAO DATE, IN A02_CODIGO INT) "
                + "BEGIN "
                + "UPDATE FATOR_06 "
                + "SET A06_TITULO = A06_TITULO, A06_DESCRICAO = A06_DESCRICAO, A06_NUM_SEQUENCIA = A06_NUM_SEQUENCIA, A04_CODIGO = A04_CODIGO, A06_CERTEZA_RESULTANTE_FATOR = A06_CERTEZA_RESULTANTE_FATOR, A06_CONTRADICAO_RESULTANTE_FATOR = A06_CONTRADICAO_RESULTANTE_FATOR,  A06_RESULTADO_FATOR = A06_RESULTADO_FATOR, A06_DT_CADASTRO = A06_DT_CADASTRO, A06_DT_ULTIMA_ALTERACAO = A06_DT_ULTIMA_ALTERACAO, A02_CODIGO = A02_CODIGO  "
                + "WHERE A06_CODIGO = A06_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureDelFator_06(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_DELFATOR_06(IN A06_CODIGO INT) "
                + "BEGIN "
                + "DELETE FROM FATOR_06 WHERE A06_CODIGO = A06_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureSelFator_06(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_SELFATOR_06(IN A06_CODIGO INT) "
                + "BEGIN "
                + "SELECT * FROM FATOR_06 WHERE A06_CODIGO = A06_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public static void main(String[] args) {
        Fator_06_Dao dao = new Fator_06_Dao();
        dao.criarTabelaFator();
        try {
            // Crie as stored procedures
            dao.createProcedureInsFator_06(dao.connection);
            System.out.println("Procedure insert criada");
            dao.createProcedureAltFator_06(dao.connection);
            System.out.println("Procedure alter criada");
            dao.createProcedureDelFator_06(dao.connection);
            System.out.println("Procedure delete criada");
            dao.createProcedureSelFator_06(dao.connection);
            System.out.println("Procedure select criada");

        } catch (SQLException e) {
            System.err.println("Erro ao criar as stored procedures: " + e.getMessage());
        }
    }

}
