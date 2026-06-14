package OOPS;

class Swiss {
    private int score;

    //Setters
    void setScore(int  newscore) {
        score=newscore;
    }
    int getScore(){
        return score;
    }
}

public class Swap {
    static void swap(Swiss s1,Swiss s2){
        Swiss s3=s1;
        s1=s2;
        s2=s3;
    }
    public static void main(String[] args) {

        Swiss s1 = new Swiss();
        s1.setScore(120);
        System.out.println("Name: "+s1.getScore());

        Swiss s2 = new Swiss();
        s2.setScore(150);
        System.out.println("Name: "+s2.getScore());
        System.out.println("Swapping through fuction");

        swap(s1,s2);                      //will not have any affect because pass by value
        System.out.println("Name: "+s1.getScore());
        System.out.println("Name: "+s2.getScore());
        System.out.println("Swapping in same function");

        Swiss s3=s1;                      //will have effect
        s1=s2;
        s2=s3;
        System.out.println("Name: "+s1.getScore());
        System.out.println("Name: "+s2.getScore());
    }
}
