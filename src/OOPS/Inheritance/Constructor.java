package OOPS.Inheritance;

import java.util.*;
class Pet {
    Pet() {
        System.out.println("Animal Constructor");
    }
}
class Cat extends Pet {
    Cat() {                        //parent class constructor call first, super()
        //super();                 //is automatically inserted by Java as the first statement of the child constructor
        System.out.println("Dog Constructor");
    }
}
public class Constructor {
    public static void main(String[] args) {
        Cat d = new Cat();
    }
}