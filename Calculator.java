import java.util.Scanner;
 
class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char ch;

        do {

            try {

                System.out.println("==============================");
                System.out.println("     ROBUST CALCULATOR         ");
                System.out.println("===============================");

                System.out.print("Enter First Number : ");
                int a = sc.nextInt();

                System.out.print("Enter Second Number : ");
                int b = sc.nextInt();

                System.out.print("Choose Operations(+ , - , * , / ) : ");
                String operator = sc.next();

                System.out.println("--------------------------------------");

                switch (operator) {

                    case "+":
                        System.out.println("Result : " + (a + b));
                        break;

                    case "-":
                        System.out.println("Result : " + (a - b));
                        break;

                    case "*":
                        System.out.println("Result : " + (a * b));
                        break;

                    case "/":

                        if (b == 0) {

                            System.out.println("Error : Cannot divided by zero");

                        } else {

                            System.out.println("Result : " + ((float) a / b));

                        }

                        break;

                    default:

                        System.out.println("Error : Invalid Operator");

                }

            } catch (Exception e) {

                System.out.println("Error : please Enter a valid numerical input");

                sc.next();

            }

            System.out.println("-------------------------");

            System.out.print("Do you want to continue? (y/n) : ");

            ch = sc.next().charAt(0);

            System.out.println();

        } while (ch == 'y' || ch == 'Y');

        System.out.println("=================================================");

        System.out.println(" Calculator Closed Successfullly ");

        System.out.println("=================================================");

        sc.close();

    }

}