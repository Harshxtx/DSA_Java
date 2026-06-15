package OOPS.Inheritance;


class Bike {
    void sound() {
        System.out.println("vrooommmm...........");
    }
    void turbo(){
        System.out.println("Turbo activated");
    }
}
class Ninja extends Bike {
    //@Override
    void sound() {
        System.out.println("zooommmmm.......");
    }
}
public class Method_Override {
    public static void main(String[] args) {
        Bike b=new Bike();
        b.sound();
        b.turbo();

        Ninja d = new Ninja();
        d.sound();
        d.turbo();
    }
}
