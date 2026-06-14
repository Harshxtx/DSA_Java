package OOPS.Inheritance;

class Vehicle {
    void engine() {
        System.out.println("vroooommm....");
    }
}
class Honda extends Vehicle {
    void horn() {
        System.out.println("honnnnkkkkk..........");
    }
}
class Ciaz extends Honda {
    void speed() {
        System.out.println("zoooommmmm....");
    }
}
public class Multilevel_Inh {
    public static void main(String[] args) {

        Ciaz ob=new Ciaz();
        ob.engine();
        ob.horn();
        ob.speed();
    }
}
