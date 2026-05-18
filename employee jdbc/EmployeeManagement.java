import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Connection con = null;

        try {

            // LOAD JDBC DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            // CREATE DATABASE CONNECTION
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "abhay"
            );

            int choice;

            // DO-WHILE LOOP FOR MENU
            do {

                // EMPLOYEE MANAGEMENT MENU
                System.out.println("\n=================================");
                System.out.println("     EMPLOYEE MANAGEMENT");
                System.out.println("=================================");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.println("=================================");

                System.out.print("Enter Your Choice : ");
                choice = sc.nextInt();

                switch (choice) {

                    // ADD EMPLOYEE
                    case 1:

                        System.out.print("Enter Employee ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Employee Name : ");
                        String name = sc.nextLine();

                        System.out.print("Enter Employee Salary : ");
                        double salary = sc.nextDouble();

                        // INSERT QUERY
                        String insertQuery =
                                "insert into employee values(?,?,?)";

                        // PREPARED STATEMENT
                        PreparedStatement insertPs =
                                con.prepareStatement(insertQuery);

                        // SET VALUES
                        insertPs.setInt(1, id);
                        insertPs.setString(2, name);
                        insertPs.setDouble(3, salary);

                        // EXECUTE INSERT QUERY
                        insertPs.executeUpdate();

                        System.out.println("Employee Added Successfully");

                        break;

                    // VIEW EMPLOYEES
                    case 2:

                        // SELECT QUERY
                        String selectQuery =
                                "select * from employee";

                        // PREPARED STATEMENT
                        PreparedStatement selectPs =
                                con.prepareStatement(selectQuery);

                        // EXECUTE SELECT QUERY
                        ResultSet rs = selectPs.executeQuery();

                        System.out.println("\n=================================");
                        System.out.println("        EMPLOYEE RECORDS");
                        System.out.println("=================================");

                        // DISPLAY EMPLOYEE RECORDS
                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt(1) + " | " +
                                    rs.getString(2) + " | " +
                                    rs.getDouble(3)
                            );
                        }

                        break;

                    // UPDATE EMPLOYEE SALARY
                    case 3:

                        System.out.print("Enter Employee ID : ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Salary : ");
                        double newSalary = sc.nextDouble();

                        // UPDATE QUERY
                        String updateQuery =
                                "update employee set salary=? where id=?";

                        // PREPARED STATEMENT
                        PreparedStatement updatePs =
                                con.prepareStatement(updateQuery);

                        // SET VALUES
                        updatePs.setDouble(1, newSalary);
                        updatePs.setInt(2, updateId);

                        // EXECUTE UPDATE QUERY
                        updatePs.executeUpdate();

                        System.out.println("Employee Salary Updated Successfully");

                        break;

                    // DELETE EMPLOYEE
                    case 4:

                        System.out.print("Enter Employee ID : ");
                        int deleteId = sc.nextInt();

                        // DELETE QUERY
                        String deleteQuery =
                                "delete from employee where id=?";

                        // PREPARED STATEMENT
                        PreparedStatement deletePs =
                                con.prepareStatement(deleteQuery);

                        // SET VALUE
                        deletePs.setInt(1, deleteId);

                        // EXECUTE DELETE QUERY
                        deletePs.executeUpdate();

                        System.out.println("Employee Deleted Successfully");

                        break;

                    // EXIT
                    case 5:

                        System.out.println("Exiting Employee Management...");
                        break;

                    // INVALID CHOICE
                    default:

                        System.out.println("Invalid Choice! Try Again.");
                }

            } while (choice != 5);

            // CLOSE DATABASE CONNECTION
            con.close();
        }

        // EXCEPTION HANDLING
        catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }

        sc.close();
    }
}
