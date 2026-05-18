import java.util.ArrayList;
import java.util.Scanner;

class Book {

    int id;
    String title;
    String author;
    boolean isIssued;

    static int totalBooks = 0;

    Book(int id, String title, String author) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;

        totalBooks++;
    }

    void issueBook() {

        if (!isIssued) {

            isIssued = true;

            System.out.println("Book Issued Successfully");

        } else {

            System.out.println("Book Already Issued");
        }
    }

    void returnBook() {

        if (isIssued) {

            isIssued = false;

            System.out.println("Book Returned Successfully");

        } else {

            System.out.println("Book Was Not Issued");
        }
    }

    void displayBook() {

        System.out.println("---------------------------------");
        System.out.println("Book ID   : " + id);
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Status    : " + (isIssued ? "Issued" : "Available"));
    }

    static void showTotalBooks() {

        System.out.println("Total Books In Library : " + totalBooks);
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> library = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. Total Books Count");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title : ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name : ");
                    String author = sc.nextLine();

                    Book b = new Book(id, title, author);

                    library.add(b);

                    System.out.println("Book Added Successfully");

                    break;

                case 2:

                    System.out.print("Enter Book ID To Issue : ");
                    int issueId = sc.nextInt();

                    boolean foundIssue = false;

                    for (Book book : library) {

                        if (book.id == issueId) {

                            book.issueBook();

                            foundIssue = true;

                            break;
                        }
                    }

                    if (!foundIssue) {

                        System.out.println("Book Not Found");
                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID To Return : ");
                    int returnId = sc.nextInt();

                    boolean foundReturn = false;

                    for (Book book : library) {

                        if (book.id == returnId) {

                            book.returnBook();

                            foundReturn = true;

                            break;
                        }
                    }

                    if (!foundReturn) {

                        System.out.println("Book Not Found");
                    }

                    break;

                case 4:

                    if (library.isEmpty()) {

                        System.out.println("No Books Available");

                    } else {

                        for (Book book : library) {

                            book.displayBook();
                        }
                    }

                    break;

                case 5:

                    Book.showTotalBooks();

                    break;

                case 6:

                    System.out.println("Exiting Library Management System...");

                    break;

                default:

                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 6);

        sc.close();
    }
}