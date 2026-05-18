import java.util.Scanner;

public class HotelBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rooms[][] = new int[3][5];

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     HOTEL ROOM BOOKING SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Exit");
            System.out.println("=================================");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nRoom Status");
                    System.out.println("0 = Available | 1 = Booked\n");

                    for (int i = 0; i < rooms.length; i++) {

                        System.out.print("Floor " + (i + 1) + " : ");

                        for (int j = 0; j < rooms[i].length; j++) {

                            System.out.print(rooms[i][j] + " ");
                        }

                        System.out.println();
                    }

                    break;

                case 2:

                    System.out.print("Enter Floor Number (1-3) : ");
                    int floor = sc.nextInt();

                    System.out.print("Enter Room Number (1-5) : ");
                    int room = sc.nextInt();

                    floor = floor - 1;
                    room = room - 1;

                    if (floor < 0 || floor >= 3 || room < 0 || room >= 5) {

                        System.out.println("Invalid Floor Or Room Number");

                    } else if (rooms[floor][room] == 0) {

                        rooms[floor][room] = 1;

                        System.out.println("Room Booked Successfully");

                    } else {

                        System.out.println("Room Already Booked");
                    }

                    break;

                case 3:

                    System.out.println("Exiting Hotel Booking System...");
                    break;

                default:

                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 3);

        sc.close();
    }
}