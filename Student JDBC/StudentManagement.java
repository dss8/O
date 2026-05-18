import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Connection con = null;

        try {

            // LOAD JDBC DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            // CREATE DATABASE CONNECTION
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "abhay"
            );

            // TRANSACTION MANAGEMENT
            con.setAutoCommit(false);

            int choice;

            // DO-WHILE LOOP FOR MENU
            do {

                // STUDENT MANAGEMENT MENU
                System.out.println("\n=================================");
                System.out.println("      STUDENT MANAGEMENT");
                System.out.println("=================================");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.println("=================================");

                System.out.print("Enter Your Choice : ");
                choice = sc.nextInt();

                switch (choice) {

                    // ADD STUDENT
                    case 1:

                        System.out.print("Enter Student ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Student Name : ");
                        String name = sc.nextLine();

                        System.out.print("Enter Student Marks : ");
                        double marks = sc.nextDouble();

                        // INSERT QUERY
                        String insertQuery =
                                "insert into student values(?,?,?)";

                        // PREPARED STATEMENT
                        PreparedStatement insertPs =
                                con.prepareStatement(insertQuery);

                        // SET VALUES
                        insertPs.setInt(1, id);
                        insertPs.setString(2, name);
                        insertPs.setDouble(3, marks);

                        // EXECUTE INSERT QUERY
                        insertPs.executeUpdate();

                        // COMMIT TRANSACTION
                        con.commit();

                        System.out.println("Student Added Successfully");

                        break;

                    // VIEW STUDENTS
                    case 2:

                        // SELECT QUERY
                        String selectQuery =
                                "select * from student";

                        // PREPARED STATEMENT
                        PreparedStatement selectPs =
                                con.prepareStatement(selectQuery);

                        // EXECUTE SELECT QUERY
                        ResultSet rs = selectPs.executeQuery();

                        System.out.println("\n=================================");
                        System.out.println("        STUDENT RECORDS");
                        System.out.println("=================================");

                        // DISPLAY RECORDS
                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt(1) + " | " +
                                    rs.getString(2) + " | " +
                                    rs.getDouble(3)
                            );
                        }

                        break;

                    // UPDATE STUDENT MARKS
                    case 3:

                        System.out.print("Enter Student ID : ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Marks : ");
                        double newMarks = sc.nextDouble();

                        // UPDATE QUERY
                        String updateQuery =
                                "update student set marks=? where id=?";

                        // PREPARED STATEMENT
                        PreparedStatement updatePs =
                                con.prepareStatement(updateQuery);

                        // SET VALUES
                        updatePs.setDouble(1, newMarks);
                        updatePs.setInt(2, updateId);

                        // EXECUTE UPDATE QUERY
                        updatePs.executeUpdate();

                        // COMMIT TRANSACTION
                        con.commit();

                        System.out.println("Student Marks Updated Successfully");

                        break;

                    // DELETE STUDENT
                    case 4:

                        System.out.print("Enter Student ID : ");
                        int deleteId = sc.nextInt();

                        // DELETE QUERY
                        String deleteQuery =
                                "delete from student where id=?";

                        // PREPARED STATEMENT
                        PreparedStatement deletePs =
                                con.prepareStatement(deleteQuery);

                        // SET VALUE
                        deletePs.setInt(1, deleteId);

                        // EXECUTE DELETE QUERY
                        deletePs.executeUpdate();

                        // COMMIT TRANSACTION
                        con.commit();

                        System.out.println("Student Deleted Successfully");

                        break;

                    // EXIT
                    case 5:

                        System.out.println("Exiting Student Management...");
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
