package myPackage;

public class Query {
    public static final String INSERT = "INSERT INTO employee (id, name, email, salary) VALUES (?, ?, ?, ?)";
    public static final String SELECT = "SELECT * FROM employee";
    public static final String UPDATE = "UPDATE employee SET name = ?, email = ?, salary = ? WHERE id = ?";
    public static final String DELETE = "DELETE FROM employee WHERE id = ?";
}
