package OOPS;

class Name {
    String name="Harshit";

    Name(String name){
        this.name=name;
    }
    Name(Name other){
        name=other.name;
    }
    void setName(String newname){
        name=newname;
    }
}

public class Shallow_Deep {
    public static void main(String[] args) {

        Name s1 = new Name("Harhsit");
        System.out.println(s1.name);

        Name s3=new Name(s1);                     //deep copy:will not change original object
        s3.setName("Tanishq");
        System.out.println(s1.name);
        System.out.println(s3.name);

        Name s2 = s1;                              //shallow copy: will change the original object
        s2.setName("Tanishq");
        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}
