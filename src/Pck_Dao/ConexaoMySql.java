package Pck_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {

    public Connection conectaBD() {

        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/empresa_db?user=root&password=";

            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Erro ConexaoMySql: " + e.getMessage());
        }

        return conn;
    }
}
