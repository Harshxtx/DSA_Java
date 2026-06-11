package Loops;

import java.util.*;
public class Prime_Num {
    boolean checkPrime(int n)
    {
        if(n==2)
            return true;
        if(n<=1 || n%2==0)
            return false;
        int i,c=0;
        for(i=3;i*i<=n;i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int i,n;
        System.out.print("Enter the no. ");
        n=in.nextInt();
        Prime_Num ob=new Prime_Num();
        if(ob.checkPrime(n))
            System.out.println("Number is prime");
        else
            System.out.println("Number is not prime");

    }

}
