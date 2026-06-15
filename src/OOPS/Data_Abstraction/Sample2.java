package OOPS.Data_Abstraction;

abstract class Employee {
    abstract void work();
    void login() {
        System.out.println("Employee logged in");
    }
}
class Developer extends Employee {
    @Override
    void work() {
        System.out.println("Writing code");
    }
}
class Tester extends Employee {
    @Override
    void work() {
        System.out.println("Testing application");
    }
}
public class Sample2 {
    public static void main(String[] args) {
        Employee[] employees = {new Developer(), new Tester()};

        for (Employee e : employees) {
            e.login();
            e.work();
        }
    }
}
