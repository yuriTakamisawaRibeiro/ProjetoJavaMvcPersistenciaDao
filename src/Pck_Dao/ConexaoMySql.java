package Pck_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {

    private static final String url = "jdbc:mysql://localhost:3306/empresadb";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn = null;

    public static Connection conectaBD() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ConexaoMySql: " + e.getMessage());
            return null;
        }
    }

    public static void desconectaBD() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
