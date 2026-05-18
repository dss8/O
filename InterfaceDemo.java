import java.util.Scanner;

interface Animal {

    void sound();

    void display();
}

class Dog implements Animal {

    String name;

    Dog(String name) {

        this.name = name;
    }

    public void sound() {

        System.out.println(name + " says : Bow Bow");
    }

    public void display() {

        System.out.println("Animal Type : Dog");
        System.out.println("Animal Name : " + name);
    }
}

class Cat implements Animal {

    String name;

    Cat(String name) {

        this.name = name;
    }

    public void sound() {

        System.out.println(name + " says : Meow Meow");
    }

    public void display() {

        System.out.println("Animal Type : Cat");
        System.out.println("Animal Name : " + name);
    }
}

public class InterfaceDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   INTERFACE & POLYMORPHISM");
        System.out.println("=================================");

        System.out.print("Enter Dog Name : ");
        String dogName = sc.nextLine();

        System.out.print("Enter Cat Name : ");
        String catName = sc.nextLine();

        Animal a;

        System.out.println("\n=================================");
        System.out.println("         DOG DETAILS");
        System.out.println("=================================");

        a = new Dog(dogName);

        a.display();
        a.sound();

        System.out.println("\n=================================");
        System.out.println("         CAT DETAILS");
        System.out.println("=================================");

        a = new Cat(catName);

        a.display();
        a.sound();

        sc.close();
    }
}