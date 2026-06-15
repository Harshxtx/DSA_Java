package OOPS.Polymorphism;

class Car {
    void sound() {
        System.out.println("vroooommmmmm...........");
    }
}
class Merc extends Car {
    void horn() {
        System.out.println("honnnnkkk.............");
    }
}
public class Downcasting {
    public static void main(String[] args) {
        Car a = new Merc();
        Merc d = (Merc) a;      // Downcasting
        d.sound();
        d.horn();
    }
}
