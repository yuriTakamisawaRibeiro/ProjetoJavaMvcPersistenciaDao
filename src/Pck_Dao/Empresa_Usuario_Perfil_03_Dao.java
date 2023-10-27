package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class Empresa_Usuario_Perfil_03_Dao {

    private Connection connection;

    public Empresa_Usuario_Perfil_03_Dao() {
        // Inicialize a conexão na construção do DAO
        connection = ConexaoMySql.conectaBD();
    }

    public void criarTabelaEmpresaUsuarioPerfil03() {
        if (connection == null) {
            System.err.println("Falha na conexão com o MySQL. A tabela não pode ser criada.");
            return;
        }

        String createTableSQL = "CREATE TABLE IF NOT EXISTS EMPRESA_USUARIO_PERFIL_03 ("
                + "A02_CODIGO INT(11) PRIMARY KEY AUTO_INCREMENT,"
                + "A01_CODIGO INT(11),"
                + "A03_DT_CADASTRO DATE,"
                + "A03_DT_ULTIMA_ALTERACAO DATE,"
                + "A03_PERFIL_PRAVIVERBEM TINYINT(1),"
                + "A03_PERFIL_ADMINISTRADOR TINYINT(1),"
                + "A03_PERFIL_CHEFE TINYINT(1),"
                + "A03_PERFIL_PADRAO TINYINT(1),"
                + "FOREIGN KEY (A01_CODIGO) REFERENCES EMPRESA_01(A01_CODIGO))";

        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
            System.out.println("Tabela 'EMPRESA_USUARIO_PERFIL_03' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela 'EMPRESA_USUARIO_PERFIL_03': " + e.getMessage());
        }
    }

    public void createProcedureInsEmpresaUsuarioPerfil03(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_INSEMPRESA_USUARIO_PERFIL_03(IN A01_CODIGO INT, IN A03_DT_CADASTRO DATE, IN A03_DT_ULTIMA_ALTERACAO DATE, IN A03_PERFIL_PRAVIVERBEM TINYINT, IN A03_PERFIL_ADMINISTRADOR TINYINT, IN A03_PERFIL_CHEFE TINYINT, IN A03_PERFIL_PADRAO TINYINT) "
                + "BEGIN "
                + "INSERT INTO EMPRESA_USUARIO_PERFIL_03 (A02_CODIGO, A03_DT_CADASTRO, A03_DT_ULTIMA_ALTERACAO, A03_PERFIL_PRAVIVERBEM, A03_PERFIL_ADMINISTRADOR, A03_PERFIL_CHEFE, A03_PERFIL_PADRAO) "
                + "VALUES (A02_CODIGO, A03_DT_CADASTRO, A03_DT_ULTIMA_ALTERACAO, A03_PERFIL_PRAVIVERBEM, A03_PERFIL_ADMINISTRADOR, A03_PERFIL_CHEFE, A03_PERFIL_PADRAO); "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureAltEmpresaUsuarioPerfil03(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_ALTEMPRESA_USUARIO_PERFIL_03(IN A01_CODIGO INT, IN A03_DT_CADASTRO DATE, IN A03_DT_ULTIMA_ALTERACAO DATE, IN A03_PERFIL_PRAVIVERBEM TINYINT, IN A03_PERFIL_ADMINISTRADOR TINYINT, IN A03_PERFIL_CHEFE TINYINT, IN A03_PERFIL_PADRAO TINYINT) "
                + "BEGIN "
                + "UPDATE EMPRESA_USUARIO_PERFIL_03 "
                + "SET A01_CODIGO = A01_CODIGO, A03_DT_CADASTRO = A03_DT_CADASTRO ,A03_DT_ULTIMA_ALTERACAO = A03_DT_ULTIMA_ALTERACAO, A03_PERFIL_PRAVIVERBEM = A03_PERFIL_PRAVIVERBEM, A03_PERFIL_ADMINISTRADOR = A03_PERFIL_ADMINISTRADOR, A03_PERFIL_CHEFE = A03_PERFIL_CHEFE, A03_PERFIL_PADRAO = A03_PERFIL_PADRAO "
                + "WHERE A02_CODIGO = A02_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureDelEmpresaUsuarioPerfil03(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_DELEMPRESA_USUARIO_PERFIL_03(IN A02_CODIGO INT) "
                + "BEGIN "
                + "DELETE FROM EMPRESA_USUARIO_PERFIL_03 WHERE A02_CODIGO = A02_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public void createProcedureSelEmpresaUsuarioPerfil03(Connection connection) throws SQLException {
        String createProcedureSQL = "CREATE PROCEDURE IF NOT EXISTS PROC_SELEMPRESA_USUARIO_PERFIL_03(IN A02_CODIGO INT) "
                + "BEGIN "
                + "SELECT * FROM EMPRESA_USUARIO_PERFIL_03 WHERE A02_CODIGO = A02_CODIGO; "
                + "END";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createProcedureSQL)) {
            preparedStatement.execute();
        }
    }

    public static void main(String[] args) {
        Empresa_Usuario_Perfil_03_Dao dao = new Empresa_Usuario_Perfil_03_Dao();
        dao.criarTabelaEmpresaUsuarioPerfil03();
        try {
            // Crie as stored procedures
            dao.createProcedureInsEmpresaUsuarioPerfil03(dao.connection);
            System.out.println("Procedure insert criada");
            dao.createProcedureAltEmpresaUsuarioPerfil03(dao.connection);
            System.out.println("Procedure alter criada");
            dao.createProcedureDelEmpresaUsuarioPerfil03(dao.connection);
            System.out.println("Procedure delete criada");
            dao.createProcedureSelEmpresaUsuarioPerfil03(dao.connection);
            System.out.println("Procedure select criada");

        } catch (SQLException e) {
            System.err.println("Erro ao criar as stored procedures: " + e.getMessage());
        }
    }
}