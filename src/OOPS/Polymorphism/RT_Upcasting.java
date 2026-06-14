package OOPS.Polymorphism;

class Pet {
    void eat() {
        System.out.println("Animal eats");
    }
}
class Mikey extends Pet {
    @Override
    void eat(){
        System.out.println("Mikey barks");
    }
    void bark() {
        System.out.println("Dog barks");
    }
}

public class RT_Upcasting {
    public static void main(String[] args) {

        Pet a = new Mikey();
        a.eat();
         //a.bark();   // Compilation Error
    }
}
