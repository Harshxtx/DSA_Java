package Recursion;

import java.util.*;

public class Fast_Power {
    double Pow(double n,int p){
        if(p==0)
            return 1;
        if(p==1)
            return n;
        if(p<0)
            return 1 / Pow(n, -p);
        double half=(Pow(n,p/2));
        if(p%2==0)
            return half*half;
        else
            return n*half*half;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Fast_Power ob = new Fast_Power();
        double n=2;
        int p=10;
        double res=ob.Pow(n,p);
        System.out.println("Power of "+n+" raised to power "+p+" is: "+res);
        p=-2;
        res=ob.Pow(n,p);
        System.out.println("Power of "+n+" raised to power "+p+" is: "+res);
    }
}
