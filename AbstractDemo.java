import java.util.Scanner;

abstract class Animal {

    String animalName;

    Animal(String animalName) {

        this.animalName = animalName;
    }

    abstract void sound();

    void display() {

        System.out.println("Animal Name : " + animalName);
    }
}

class Dog extends Animal {

    Dog(String animalName) {

        super(animalName);
    }

    void sound() {

        System.out.println(animalName + " says : Bow Bow");
    }

    void showDog() {

        display();

        sound();
    }
}

public class AbstractDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("    ABSTRACT CLASS DEMO");
        System.out.println("=================================");

        System.out.print("Enter Dog Name : ");
        String name = sc.nextLine();

        Dog d1 = new Dog(name);

        System.out.println("\n=================================");
        System.out.println("         DOG DETAILS");
        System.out.println("=================================");

        d1.showDog();

        sc.close();
    }
}