package OOPS.Inheritance;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();    // inherited
        d.bark();   // own method
    }
}
