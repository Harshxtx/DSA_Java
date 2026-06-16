package OOPS.Interfaces;

import java.util.*;
interface Vehicle{
    int x=10;                   //equivalent to: public static final int x=10;
    void start();               //equivalent to: public abstract void start()
    void stop();
}
class Car implements Vehicle{
    public void start(){                  //must be public as we cannot reduce visibility while overriding
        System.out.println("Car starts");
    }
    public void stop(){
        System.out.println("Car stops");
    }
}
public class Interface {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Vehicle ob = new Car();
        ob.start();
        ob.stop();
        //ob.x=20;                    //cause error
        System.out.println(ob.x);
    }
}
