// File: Student.java
package myPackage;

import java.sql.*;
import java.util.Scanner;

public class Student {

    private final String url = "jdbc:mysql://localhost:3306/";
    private final String dbName = "codingwallahdb";
    private final String user = "root";
    private final String password = "root";

    public void setupDatabaseAndTable() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Create Database if not exists
            String createDb = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.execute(createDb);
            System.out.println("✅ Database created or exists.");

        } catch (SQLException e) {
            System.out.println("❌ Error creating database.");
            e.printStackTrace();
        }

        // Create Table
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
             Statement stmt = conn.createStatement()) {

            String createTable = "CREATE TABLE IF NOT EXISTS student ("
                    + "sid INT PRIMARY KEY, "
                    + "sname VARCHAR(100), "
                    + "semail VARCHAR(100))";
            stmt.execute(createTable);
            System.out.println("✅ Table 'student' created or exists.");

        } catch (SQLException e) {
            System.out.println("❌ Error creating table.");
            e.printStackTrace();
        }
    }

    public void insertData() {
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password)) {
            String query = "INSERT INTO student (sid, sname, semail) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, 1);
            pstmt.setString(2, "Aman");
            pstmt.setString(3, "aman@gmail.com");

            pstmt.executeUpdate();
            System.out.println("✅ Data inserted.");

        } catch (SQLException e) {
            System.out.println("❌ Error inserting data.");
            e.printStackTrace();
        }
    }

    public void readData() {
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            System.out.println("📋 Student Records:");
            while (rs.next()) {
                System.out.println(rs.getInt("sid") + " | " + rs.getString("sname") + " | " + rs.getString("semail"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error reading data.");
            e.printStackTrace();
        }
    }

    public void updateData(int id, String newEmail) {
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password)) {
            String query = "UPDATE student SET semail = ? WHERE sid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, newEmail);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();
            System.out.println("🔄 Updated " + rows + " row(s).");

        } catch (SQLException e) {
            System.out.println("❌ Error updating data.");
            e.printStackTrace();
        }
    }

    public void deleteData(int id) {
        try (Connection conn = DriverManager.getConnection(url + dbName, user, password)) {
            String query = "DELETE FROM student WHERE sid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            System.out.println("🗑️ Deleted " + rows + " row(s).");

        } catch (SQLException e) {
            System.out.println("❌ Error deleting data.");
            e.printStackTrace();
        }
    }
}
