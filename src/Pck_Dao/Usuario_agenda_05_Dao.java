package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario_agenda_05_Dao {

    private Connection connection;

    public Usuario_agenda_05_Dao() {
        // Inicialize a conexão na construção do DAO
        connection = ConexaoMySql.conectaBD();
    }

    public void criarTabelaUsuarioAgenda05() {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. A tabela não pode ser criada.");
            return;
        }

        // SQL para criar a tabela
        String createTableSQL = "CREATE TABLE IF NOT EXISTS USUARIO_AGENDA_05 ("
                + "A05_CODIGO INT(11) AUTO_INCREMENT PRIMARY KEY,"
                + "A04_CODIGO INT(11),"
                + "A02_CODIGO INT(11),"
                + "A05_NUM_SEQUENCIA INT(11),"
                + "A05_PERFIL_AGENDA_USUARIO_TITULAR TINYINT(1),"
                + "A05_PERFIL_AGENDA_USUARIO_FACILITADOR TINYINT(1),"
                + "A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA TINYINT(1),"
                + "A05_PERFIL_AGENDA_USUARIO_ANALISTA TINYINT(1),"
                + "A05_DT_CADASTRO DATE,"
                + "A05_DT_ULTIMA_ALTERACAO DATE,"
                + "FOREIGN KEY (A02_CODIGO) REFERENCES USUARIO_02(A02_CODIGO),"
                + "FOREIGN KEY (A04_CODIGO) REFERENCES AGENDA_04(A04_CODIGO))";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
            System.out.println("Tabela 'USUARIO_AGENDA_05' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'USUARIO_AGENDA_05': " + e.getMessage());
        }
    }

    public void createProcedureInsAgendaUsuario(Connection connection) {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. Não é possível criar a stored procedure.");
            return;
        }

        // SQL para criar a stored procedure de inserção
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_INSAGENDAUSUARIO_05("
                + "A04_CODIGO INT, A02_CODIGO INT, A05_NUM_SEQUENCIA INT, "
                + "A05_PERFIL_AGENDA_USUARIO_TITULAR TINYINT, A05_PERFIL_AGENDA_USUARIO_FACILITADOR TINYINT, "
                + "A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA TINYINT, A05_PERFIL_AGENDA_USUARIO_ANALISTA TINYINT, "
                + "A05_DT_CADASTRO DATE, A05_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "INSERT INTO USUARIO_AGENDA_05 (A04_CODIGO, A02_CODIGO, A05_NUM_SEQUENCIA, "
                + "A05_PERFIL_AGENDA_USUARIO_TITULAR, A05_PERFIL_AGENDA_USUARIO_FACILITADOR, "
                + "A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA, A05_PERFIL_AGENDA_USUARIO_ANALISTA, "
                + "A05_DT_CADASTRO, A05_DT_ULTIMA_ALTERACAO) "
                + "VALUES (A04_CODIGO, A02_CODIGO, A05_NUM_SEQUENCIA, A05_PERFIL_AGENDA_USUARIO_TITULAR, "
                + "A05_PERFIL_AGENDA_USUARIO_FACILITADOR, A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA, "
                + "A05_PERFIL_AGENDA_USUARIO_ANALISTA, A05_DT_CADASTRO, A05_DT_ULTIMA_ALTERACAO); "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
            System.out.println("Stored procedure de inserção criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a stored procedure de inserção: " + e.getMessage());
        }
    }

    public void createProcedureAltAgendaUsuario(Connection connection) {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. Não é possível criar a stored procedure.");
            return;
        }

        // SQL para criar a stored procedure de atualização
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_ALTAGENDAUSUARIO_05("
                + "A04_CODIGO INT, A02_CODIGO INT, A05_NUM_SEQUENCIA INT, "
                + "A05_PERFIL_AGENDA_USUARIO_TITULAR TINYINT, A05_PERFIL_AGENDA_USUARIO_FACILITADOR TINYINT, "
                + "A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA TINYINT, A05_PERFIL_AGENDA_USUARIO_ANALISTA TINYINT, "
                + "A05_DT_CADASTRO DATE, A05_DT_ULTIMA_ALTERACAO DATE) "
                + "BEGIN "
                + "UPDATE USUARIO_AGENDA_05 "
                + "SET A04_CODIGO = A04_CODIGO, A02_CODIGO = A02_CODIGO, A05_NUM_SEQUENCIA = A05_NUM_SEQUENCIA, "
                + "A05_PERFIL_AGENDA_USUARIO_TITULAR = A05_PERFIL_AGENDA_USUARIO_TITULAR, "
                + "A05_PERFIL_AGENDA_USUARIO_FACILITADOR = A05_PERFIL_AGENDA_USUARIO_FACILITADOR, "
                + "A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA = A05_PERFIL_AGENDA_USUARIO_ESPECIALISTA, "
                + "A05_PERFIL_AGENDA_USUARIO_ANALISTA = A05_PERFIL_AGENDA_USUARIO_ANALISTA, "
                + "A05_DT_CADASTRO = A05_DT_CADASTRO, A05_DT_ULTIMA_ALTERACAO = A05_DT_ULTIMA_ALTERACAO "
                + "WHERE A05_CODIGO = A05_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
            System.out.println("Stored procedure de atualização criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a stored procedure de atualização: " + e.getMessage());
        }
    }

    public void createProcedureDelAgendaUsuario(Connection connection) {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. Não é possível criar a stored procedure.");
            return;
        }

        // SQL para criar a stored procedure de exclusão
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_DELAGENDAUSUARIO_05("
                + "A05_CODIGO INT) "
                + "BEGIN "
                + "DELETE FROM USUARIO_AGENDA_05 WHERE A05_CODIGO = A05_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
            System.out.println("Stored procedure de exclusão criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a stored procedure de exclusão: " + e.getMessage());
        }
    }

    public void createProcedureSelAgendaUsuario(Connection connection) {
        // Certifique-se de que a conexão foi estabelecida com sucesso
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. Não é possível criar a stored procedure.");
            return;
        }

        // SQL para criar a stored procedure de seleção
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_SELAGENDAUSUARIO_05("
                + "A05_CODIGO INT) "
                + "BEGIN "
                + "SELECT * FROM USUARIO_AGENDA_05 WHERE A05_CODIGO = A05_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
            System.out.println("Stored procedure de seleção criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a stored procedure de seleção: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        Usuario_agenda_05_Dao dao = new Usuario_agenda_05_Dao();
        dao.criarTabelaUsuarioAgenda05();
        // Crie as stored procedures
        dao.createProcedureInsAgendaUsuario(dao.connection);
        System.out.println("Procedure insert criada");
        dao.createProcedureAltAgendaUsuario(dao.connection);
        System.out.println("Procedure alter criada");
        dao.createProcedureDelAgendaUsuario(dao.connection);
        System.out.println("Procedure delete criada");
        dao.createProcedureSelAgendaUsuario(dao.connection);
        System.out.println("Procedure select criada");
    }
}
