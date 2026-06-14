package OOPS;

class Student {
    String name;
    int roll_no;
    int grade;
    char section;

    Student(String n,int r,int c,char s){
        name=n;
        roll_no=r;
        grade=c;
        section=s;
    }
    Student(){                                  //constructor overloa
        name="Hacker";
        roll_no=Integer.MAX_VALUE;
        grade=67;
        section='X';
    }
    void display(){
        System.out.println("Student name: "+name);
        System.out.println("Roll No.: "+roll_no);
        System.out.println("Class: "+grade);
        System.out.println("Section: "+section);
    }
}

public class Constructor {
    public static void main(String[] args) {

        Student s1 = new Student("Harshit",147,14,'D');
        s1.display();
        System.out.println();

        Student  s2= new Student("Tanishq",225,14,'E');
        s2.display();

        Student  s3= new Student();
        s3.display();
    }
}
