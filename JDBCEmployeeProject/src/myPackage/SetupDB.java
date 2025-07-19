package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SetupDB {
    public static void main(String[] args) {
        String baseUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "codingwallahdb";
        String user = "root";
        String password = "root";

        try {
            // Step 1: Create DB if not exists
            try (Connection conn = DriverManager.getConnection(baseUrl, user, password);
                 Statement stmt = conn.createStatement()) {

                String createDbQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;
                stmt.execute(createDbQuery);
                System.out.println("✅ Database created or already exists.");
            }

            // Step 2: Connect to the DB and create the table
            try (Connection conn = DriverManager.getConnection(baseUrl + dbName, user, password);
                 Statement stmt = conn.createStatement()) {

                String createTableQuery = "CREATE TABLE IF NOT EXISTS employee ("
                        + "id INT PRIMARY KEY, "
                        + "name VARCHAR(100), "
                        + "email VARCHAR(100), "
                        + "salary INT"
                        + ")";
                stmt.execute(createTableQuery);
                System.out.println("✅ Table 'employee' created or already exists.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error during setup:");
            e.printStackTrace();
        }
    }
}
