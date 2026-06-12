package String;

public class Strings {
    public static void main(String args[]) {
        String s1="Hello";
        String s2="Hello";
        String str=new String("Hello");

        System.out.println(s1);

        System.out.println(s1==s2);         //true
        System.out.println(s1==str);        //false
        System.out.println(s1.equals(str)); //true
    }
}
