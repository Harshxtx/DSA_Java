package OOPS.Polymorphism;

class A {

    void eat() {
        System.out.println("A");
    }
}
class B extends A {
    void bark() {
        System.out.println("Dog barks");
    }
}
public class Upcasting {
    public static void main(String[] args) {

        A a = new B();
        a.eat();
        //a.bark();   // Compilation Error
    }
}
