package OOPS.Inheritance;

class Car {
    void engine() {
        System.out.println("vrooommmm.............");
    }
}
class BMW extends Car {

    void horn() {
        System.out.println("honnnnkkk......");
    }
}

public class Single_Inh {

    public static void main(String[] args) {
        BMW d=new BMW();
        d.engine();   // inherited
        d.horn();  // own method
    }
}
