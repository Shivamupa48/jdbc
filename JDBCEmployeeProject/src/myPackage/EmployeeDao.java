package myPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public void create(Employee emp) {
        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(Query.INSERT)) {

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getEmail());
            ps.setInt(4, emp.getSalary());

            ps.executeUpdate();
            System.out.println("Employee added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> read() {
        List<Employee> list = new ArrayList<>();

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(Query.SELECT);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("salary")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void update(Employee emp) {
        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(Query.UPDATE)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setInt(3, emp.getSalary());
            ps.setInt(4, emp.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(Query.DELETE)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
