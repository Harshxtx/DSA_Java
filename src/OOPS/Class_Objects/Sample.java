package OOPS.Class_Objects;

class Test {

    Test() {
        System.out.println("A");
    }
    Test(int x) {
        this();
        System.out.println("B");
    }
}
public class Sample {

    public static void main(String[] args) {
        Test t = new Test(10);
    }
}
