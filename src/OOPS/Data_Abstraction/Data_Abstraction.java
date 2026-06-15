package OOPS.Data_Abstraction;

abstract class Animal {
    abstract void makeSound();
    abstract void eat();
}
class Dog extends Animal{
    void makeSound() {
        System.out.println("Dog barks");
    }
    void eat(){
        System.out.println("Dog eats");
    }
}
class Cat extends Animal {
    void makeSound() {
        System.out.println("Cat Meows");
    }
    void eat(){
        System.out.println("Cat eats");
    }
}
//class Fish extends Animal{    //error
//                              //here is the main difference, abstract force all the class to have same method as it has
//}                             //either it has abstract keyword
public class Data_Abstraction {
    public static void main(String[] args) {
        //Animal ob=new Animal();           //cause error   //cannot create object for abstract class
        Animal dog=new Dog();
        dog.makeSound();
        dog.eat();
        System.out.println();

        Animal cat=new Cat();
        cat.makeSound();
        cat.eat();
    }
}
