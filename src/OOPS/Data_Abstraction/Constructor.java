package OOPS.Data_Abstraction;

abstract class Pet {
    Pet() {
        System.out.println("Animal Constructor");
    }
}
class Mike extends Pet {
    Mike() {
        System.out.println("Dog Constructor");
    }
}
public class Constructor {
    public static void main(String[] args) {
        Mike d = new Mike();
    }
}
