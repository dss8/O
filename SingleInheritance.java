import java.util.Scanner;

class Animal {

    String animalName;
    int animalAge;

    Animal(String animalName, int animalAge) {

        this.animalName = animalName;
        this.animalAge = animalAge;
    }

    void eat() {

        System.out.println(animalName + " is Eating");
    }

    void sleep() {

        System.out.println(animalName + " is Sleeping");
    }

    void displayAnimal() {

        System.out.println("Animal Name : " + animalName);
        System.out.println("Animal Age  : " + animalAge);
    }
}

class Dog extends Animal {

    String breed;

    Dog(String animalName, int animalAge, String breed) {

        super(animalName, animalAge);

        this.breed = breed;
    }

    void bark() {

        System.out.println(animalName + " is Barking");
    }

    void displayDog() {

        displayAnimal();

        System.out.println("Dog Breed   : " + breed);

        eat();
        sleep();
        bark();
    }
}

public class SingleInheritance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     SINGLE INHERITANCE DEMO");
        System.out.println("=================================");

        System.out.print("Enter Animal Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Animal Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Dog Breed : ");
        String breed = sc.nextLine();

        Dog d1 = new Dog(name, age, breed);

        System.out.println("\n=================================");
        System.out.println("          DOG DETAILS");
        System.out.println("=================================");

        d1.displayDog();

        sc.close();
    }
}