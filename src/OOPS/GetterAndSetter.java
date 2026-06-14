package OOPS;

class Info {
    private String name;
    private String course;
    private String branch;

    //Setters
    void setName(String newname){
        name=newname;
    }
    void setCourse(String newcourse){
        course=newcourse;
    }
    void setBranch(String newbranch) {
        branch=newbranch;
    }
    //getters
    String getName(){
        return name;
    }
    String getCourse(){
        return course;
    }
    String getBranch(){
        return branch;
    }
}

public class GetterAndSetter {
    public static void main(String[] args) {

        Info s1 = new Info();
        s1.setName("Harshit");
        s1.setCourse("B.Tech");
        s1.setBranch("CSE");
        System.out.println("Name: "+s1.getName());
        System.out.println("Course: "+s1.getCourse());
        System.out.println("Branch: "+s1.getBranch());
    }
}
