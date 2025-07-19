package myPackage;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDao();

        while (true) {
            System.out.println("\nEmployee Management");
            System.out.println("1 = Create, 2 = Read, 3 = Update, 4 = Delete, 5 = Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    int salary = sc.nextInt();

                    dao.create(new Employee(id, name, email, salary));
                    break;

                case 2:
                    List<Employee> list = dao.read();
                    for (Employee e : list) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();  // consume newline
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String uemail = sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    int usalary = sc.nextInt();

                    dao.update(new Employee(uid, uname, uemail, usalary));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.delete(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
