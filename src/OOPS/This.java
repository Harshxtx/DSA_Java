package OOPS;

class Const {
    int x;
//    Const(int x){                     //Output: 0
//        x=x;                          //parameterName=parameterName
//    }
    Const(int x){                       //Output: 10
        this.x=x;                       //instance variable=parameter
    }
    void display(){
        System.out.println(x);
    }
}

public class This {
    public static void main(String[] args) {

        Const s1 = new Const(10);
        s1.display();

        System.out.println();
    }
}
