package Recursion;

import java.util.*;

public class Palindrome_Check {
    boolean checkPalin(String s,int l,int r){
        if(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            return checkPalin(s,l+1,r-1);
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Palindrome_Check ob = new Palindrome_Check();
        String s1="hello";
        String s2="madam";
        if(ob.checkPalin(s1,0,s1.length()-1))
            System.out.println("The String "+s1+" is palindrome");
        else
            System.out.println("The String "+s1+" is not palindrome");
        if(ob.checkPalin(s2,0,s2.length()-1))
            System.out.println("The String "+s2+" is palindrome");
        else
            System.out.println("The String "+s2+" is not palindrome");
    }
}
