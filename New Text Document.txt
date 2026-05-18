import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ACCOUNT BALANCE
        double balance = 5000;

        int choice;

        // DO-WHILE LOOP FOR CONTINUOUS ATM MENU
        do {

            // ATM MENU
            System.out.println("\n=================================");
            System.out.println("          ATM MACHINE");
            System.out.println("=================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("=================================");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();

            // TRY BLOCK FOR RISKY CODE
            try {

                switch (choice) {

                    // CHECK BALANCE
                    case 1:

                        System.out.println("Current Balance : " + balance);

                        break;

                    // DEPOSIT MONEY
                    case 2:

                        System.out.print("Enter Deposit Amount : ");
                        double deposit = sc.nextDouble();

                        // INVALID DEPOSIT CHECK
                        if (deposit <= 0) {

                            // THROW ILLEGAL ARGUMENT EXCEPTION
                            throw new IllegalArgumentException("Invalid Deposit Amount");
                        }

                        balance = balance + deposit;

                        System.out.println("Amount Deposited Successfully");
                        System.out.println("Updated Balance : " + balance);

                        break;

                    // WITHDRAW MONEY
                    case 3:

                        System.out.print("Enter Withdraw Amount : ");
                        double withdraw = sc.nextDouble();

                        // INVALID WITHDRAW CHECK
                        if (withdraw <= 0) {

                            // THROW ILLEGAL ARGUMENT EXCEPTION
                            throw new IllegalArgumentException("Invalid Withdraw Amount");
                        }

                        // INSUFFICIENT BALANCE CHECK
                        if (withdraw > balance) {

                            // THROW ARITHMETIC EXCEPTION
                            throw new ArithmeticException("Insufficient Balance");
                        }

                        balance = balance - withdraw;

                        System.out.println("Amount Withdrawn Successfully");
                        System.out.println("Remaining Balance : " + balance);

                        break;

                    // EXIT
                    case 4:

                        System.out.println("Thank You For Using ATM");

                        break;

                    // INVALID MENU CHOICE
                    default:

                        System.out.println("Invalid Choice! Try Again.");
                }

            }

            // HANDLE ARITHMETIC EXCEPTION
            catch (ArithmeticException e) {

                System.out.println("Error : " + e.getMessage());
            }

            // HANDLE ILLEGAL ARGUMENT EXCEPTION
            catch (IllegalArgumentException e) {

                System.out.println("Error : " + e.getMessage());
            }

            // HANDLE INVALID INPUT EXCEPTION
            catch (Exception e) {

                System.out.println("Error : Invalid Input");

                sc.nextLine();
            }

            // FINALLY BLOCK
            finally {

                System.out.println("Transaction Process Completed");
            }

        } while (choice != 4);

        sc.close();
    }
}