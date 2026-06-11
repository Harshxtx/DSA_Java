import java.util.*;
public class DTypes {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //Primitive Data Types
        //1)Non-numeric
        char ch= 'J';               //in.next().charAt(0); //default: \u0000
        boolean Java=true;          //in.nextBoolean       //default: false
        //2)Numeric
        byte b=10;                  //in.nextByte();       //default: 0
        short s=20;                 //in.nextShort();      //default: 0
        int i=302212;               //in.nextInt;          //default: 0
        long l=400980982870L;       //in.nextLong();       //default: 0L
        //3)Floating point
        float f=3.14f;              //in.nextFloat();      //default: 0.0f    //'f' is compulsory
        double d=3.141592653589793d;//in.nextDouble()      //default: 0.0d

        //Non-Primitive Data Types
        String st="Java is my favourite"; //in.next(); OR in.nextLine();
        int arr[]={1,2,3,4,5};            //new int[arraysize]  //default:0 for each cell
        Integer n1= 20;                   //wrapper class

        System.out.println("Is Java your favourite"+Java);
        System.out.println("Byte value: "+b);
        System.out.println("Short value: "+s);
        System.out.println("Integer value: "+i);
        System.out.println("Long value: "+l);
        System.out.println("Float value: "+f);
        System.out.println("Double Value: "+d);
        System.out.println("Character Value: "+ch);
        System.out.println("What is your opinion about java: "+st);
        System.out.println("First element of array: "+arr[0]);
        System.out.println("Value of Integer object: "+n1);
    }
}
