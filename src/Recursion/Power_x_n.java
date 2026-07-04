package Recursion;

import java.util.*;

public class Power_x_n {
    double Pow(double n,int p){
        if(p==0)
            return 1;
        else if(p<0)
            return 1/Pow(n,-p);
        return n*Pow(n,p-1);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Power_x_n ob = new Power_x_n();
        double n=2;
        int p=10;
        double res=ob.Pow(n,p);
        System.out.println("Power of "+n+" raised to power "+p+" is: "+res);
        p=-2;
        res=ob.Pow(n,p);
        System.out.println("Power of "+n+" raised to power "+p+" is: "+res);
    }
}
