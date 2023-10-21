package Pck_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {

    private static final String url = "jdbc:mysql://localhost:3306/empresa_db";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn = null;

    public static Connection conectaBD() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else
                return conn;

        } catch (SQLException e) {
            System.out.println("Erro ConexaoMySql: " + e.getMessage());
            return null;
        }

    }
}
