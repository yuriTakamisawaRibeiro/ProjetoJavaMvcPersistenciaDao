package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario_02_Dao {

    private Connection connection;

    public Usuario_02_Dao() {
        // Inicialize a conexão na construção do DAO
        connection = ConexaoMySql.conectaBD();
    }

    public void criarTabelaUsuario02() {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. A tabela não pode ser criada.");
            return;
        }

        // SQL para criar a tabela
        String createTableSQL = "CREATE TABLE IF NOT EXISTS USUARIO_02 ("
                + "A02_CODIGO INT(11) AUTO_INCREMENT PRIMARY KEY,"
                + "A02_NOME TEXT,"
                + "A02_USUARIO TEXT,"
                + "A02_SENHA TEXT,"
                + "A02_CODIGO_LINK TEXT,"
                + "A02_EMAIL TEXT ,"
                + "A02_STATUS TINYINT(1),"
                + "A02_DT_CADASTRO DATE,"
                + "A02_DT_ULTIMA_ALTERACAO DATE)";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
            System.out.println("Tabela 'USUARIO_02' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'USUARIO_02': " + e.getMessage());
        }
    }

    public void createProcedureInsUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_INSUSUARIO_02(A02_NOME TEXT, A02_USUARIO TEXT, A02_SENHA TEXT, A02_CODIGO_LINK TEXT, A02_EMAIL TEXT, A02_STATUS TINYINT, A02_DT_CADASTRO DATE, A02_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "INSERT INTO USUARIO_02 (A02_NOME, A02_USUARIO, A02_SENHA, A02_CODIGO_LINK, A02_EMAIL, A02_STATUS, A02_DT_CADASTRO, A02_DT_ULTIMA_ALTERACAO) "
                + "VALUES (A02_NOME, A02_USUARIO, A02_SENHA, A02_CODIGO_LINK, A02_EMAIL, A02_STATUS, A02_DT_CADASTRO, A02_DT_ULTIMA_ALTERACAO); "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureAltUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_ALTUSUARIO_02( A02_NOME TEXT, A02_USUARIO TEXT, A02_SENHA TEXT, A02_CODIGO_LINK TEXT, A02_EMAIL TEXT, A02_STATUS TINYINT, A02_DT_CADASTRO DATE, A02_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "UPDATE USUARIO_02 "
                + "SET A02_NOME = A02_NOME, A02_USUARIO = A02_USUARIO, A02_SENHA = A02_SENHA, A02_CODIGO_LINK = A02_CODIGO_LINK, A02_EMAIL = A02_EMAIL, A02_STATUS = A02_STATUS, A02_DT_CADASTRO = A02_DT_CADASTRO, A02_DT_ULTIMA_ALTERACAO = A02_DT_ULTIMA_ALTERACAO "
                + "WHERE A02_CODIGO = A02_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureDelUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_DELUSUARIO_02(A02_CODIGO INT) "
                + "BEGIN "
                + "DELETE FROM USUARIO_02 WHERE A02_CODIGO = A02_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureSelUsuario(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_SELUSUARIO_02(A02_CODIGO INT) "
                + "BEGIN "
                + "SELECT * FROM USUARIO_02 WHERE A02_CODIGO = A02_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public static void main(String[] args) {
        Usuario_02_Dao dao = new Usuario_02_Dao();
        dao.criarTabelaUsuario02();
        try {
            // Crie as stored procedures
            dao.createProcedureInsUsuario(dao.connection);
            System.out.println("Procedure insert criada");
            dao.createProcedureAltUsuario(dao.connection);
            System.out.println("Procedure alter criada");
            dao.createProcedureDelUsuario(dao.connection);
            System.out.println("Procedure delete criada");
            dao.createProcedureSelUsuario(dao.connection);
            System.out.println("Procedure select criada");

        } catch (SQLException e) {
            System.err.println("Erro ao criar as stored procedures: " + e.getMessage());
        }
    }
}
