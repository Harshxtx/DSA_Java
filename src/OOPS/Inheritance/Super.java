package OOPS.Inheritance;

class Bird {
    String name = "Bird";
}
class Duck extends Bird {
    String name = "Duck";

    void display() {
        System.out.println(name);       //child class name
        System.out.println(super.name); //parent class name
    }
}
public class Super {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.display();
    }
}
