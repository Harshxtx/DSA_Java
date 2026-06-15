package OOPS.Encapsulation;


class Marks {
    private int marks;
    void setMarks(int marks) {
        if(marks >= 0 && marks <= 100)
            this.marks = marks;
        else
            System.out.println("Invalid Marks");
    }
    int getMarks() {
        return marks;
    }
}
public class Validation {

    public static void main(String[] args) {

        Marks s = new Marks();

        s.setMarks(90);
        System.out.println("Marks: " + s.getMarks());
        s.setMarks(150);
    }
}