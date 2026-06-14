package OOPS;

class Employee {

    private int id;
    Employee(int id) {
        this.id = id;
    }
    int getId() {
        return id;
    }
}

public class RO_File {
    public static void main(String[] args) {

        Employee e = new Employee(101);

        System.out.println("ID: " + e.getId());
    }
}