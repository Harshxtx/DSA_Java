package OOPS.Encapsulation;

class Std {
    private int marks;
    void setMarks(int marks) {
        this.marks = marks;
    }
    int getMarks() {
        return marks;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Std s = new Std();
        s.setMarks(95);
        System.out.println("Marks: " + s.getMarks());
        // s.marks = 100;   // Compilation Error
    }
}
