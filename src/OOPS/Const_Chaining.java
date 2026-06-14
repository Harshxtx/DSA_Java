package OOPS;

class Chain {
    String name;
    int age;

    // Default constructor
    Chain() {
        this("Unknown");                        //Calls Student(String)
        System.out.println("Default Constructor");
    }

    // One-parameter constructor
    Chain(String name) {
        this(name, 18);                         //Calls Student(String, int)
        System.out.println("One-parameter Constructor");
    }

    // Two-parameter constructor
    Chain(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Two-parameter Constructor");
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Const_Chaining {
    public static void main(String[] args) {
        Chain s1 = new Chain();
        System.out.println();

        Chain s2 = new Chain("Harshit");
        System.out.println();

        Chain s3 = new Chain("Ninja", 20);
        System.out.println("\nStudent Details:");
        s1.display();
        s2.display();
        s3.display();
    }
}
