package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Parecer_fator_usuario_07_Dao {

    private Connection connection;

    public Parecer_fator_usuario_07_Dao() {
        // Inicialize a conexão na construção do DAO
        connection = ConexaoMySql.conectaBD();
    }

    public void criarTabelaParecerFatorUsuario07() {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. A tabela não pode ser criada.");
            return;
        }

        // SQL para criar a tabela
        String createTableSQL = "CREATE TABLE IF NOT EXISTS PARECER_FATOR_USUARIO_07 ("
                + "A07_CODIGO INT(11) AUTO_INCREMENT PRIMARY KEY,"
                + "A06_CODIGO INT(11),"
                + "A02_CODIGO INT(11),"
                + "A07_NUM_SEQUENCIA INT(11),"
                + "A07_CERTEZA DOUBLE,"
                + "A07_CONTRADICAO DOUBLE,"
                + "A07_DT_CADASTRO DATE,"
                + "A07_DT_ULTIMA_ALTERACAO DATE,"
                + "FOREIGN KEY (A06_CODIGO) REFERENCES FATOR_06(A06_CODIGO),"
                + "FOREIGN KEY (A02_CODIGO) REFERENCES USUARIO_02(A02_CODIGO))";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
            System.out.println("Tabela 'PARECER_FATOR_USUARIO_07' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'PARECER_FATOR_USUARIO_07': " + e.getMessage());
        }
    }

    public void createProcedureInsParecerFatorUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_INSPARECER_FATOR_USUARIO_07(A06_CODIGO INT, A02_CODIGO INT, A07_NUM_SEQUENCIA INT, A07_CERTEZA DOUBLE, A07_CONTRADICAO DOUBLE, A07_DT_CADASTRO DATE, A07_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "INSERT INTO PARECER_FATOR_USUARIO_07 (A06_CODIGO, A02_CODIGO, A07_NUM_SEQUENCIA, A07_CERTEZA, A07_CONTRADICAO, A07_DT_CADASTRO, A07_DT_ULTIMA_ALTERACAO) "
                + "VALUES (A06_CODIGO, A02_CODIGO, A07_NUM_SEQUENCIA, A07_CERTEZA, A07_CONTRADICAO, A07_DT_CADASTRO, A07_DT_ULTIMA_ALTERACAO); "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureAltParecerFatorUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_ALTPARECER_FATOR_USUARIO_07(A06_CODIGO INT, A02_CODIGO INT, A07_NUM_SEQUENCIA INT, A07_CERTEZA DOUBLE, A07_CONTRADICAO DOUBLE, A07_DT_CADASTRO DATE, A07_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "UPDATE PARECER_FATOR_USUARIO_07 "
                + "SET A06_CODIGO = A06_CODIGO, A02_CODIGO = A02_CODIGO, A07_NUM_SEQUENCIA = A07_NUM_SEQUENCIA, A07_CERTEZA = A07_CERTEZA, A07_CONTRADICAO = A07_CONTRADICAO, A07_DT_CADASTRO = A07_DT_CADASTRO, A07_DT_ULTIMA_ALTERACAO = A07_DT_ULTIMA_ALTERACAO "
                + "WHERE A07_CODIGO = A07_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureDelParecerFatorUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_DELPARECER_FATOR_USUARIO_07(A07_CODIGO INT) "
                + "BEGIN "
                + "DELETE FROM PARECER_FATOR_USUARIO_07 WHERE A07_CODIGO = A07_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureSelParecerFatorUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_SELPARECER_FATOR_USUARIO_07(A07_CODIGO INT) "
                + "BEGIN "
                + "SELECT * FROM PARECER_FATOR_USUARIO_07 WHERE A07_CODIGO = A07_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public static void main(String[] args) {
        Parecer_fator_usuario_07_Dao dao = new Parecer_fator_usuario_07_Dao();
        dao.criarTabelaParecerFatorUsuario07();
        try {
            // Crie as stored procedures
            dao.createProcedureInsParecerFatorUsuario(dao.connection);
            System.out.println("Procedure insert criada");
            dao.createProcedureAltParecerFatorUsuario(dao.connection);
            System.out.println("Procedure alter criada");
            dao.createProcedureDelParecerFatorUsuario(dao.connection);
            System.out.println("Procedure delete criada");
            dao.createProcedureSelParecerFatorUsuario(dao.connection);
            System.out.println("Procedure select criada");

        } catch (SQLException e) {
            System.err.println("Erro ao criar as stored procedures: " + e.getMessage());
        }
    }
}
