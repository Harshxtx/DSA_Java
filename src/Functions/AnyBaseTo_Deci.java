package Functions;

import java.util.*;
public class AnyBaseTo_Deci {
    int ConvertoDeci(int n,int b){
        int res=0,p=1;
        while(n>0){
            int r=n%10;
            if(r>=b)
                return -1;
            res=res+(r*p);
            p=p*b;
            n/=10;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=50,b=8;
        System.out.println("Enter the no.");
        //num = in.nextInt();
        System.out.println("Enter the Base");
        //b = in.nextInt();
        AnyBaseTo_Deci ob=new AnyBaseTo_Deci();
        int conv=ob.ConvertoDeci(num,b);
        if(conv!=-1)
            System.out.println("Number= " + num + " \nNumebr after the base conversion number to decimal= " + conv);
        else
            System.out.println("Invalid number");
    }
}
