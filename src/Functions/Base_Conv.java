package Functions;

import java.util.*;
public class Base_Conv {
    int AnyBaseConversion(int n,int b){
        int res=0,p=1;
        while(n>0){
            int r=n%b;
            res=res+(r*p);
            p=p*10;
            n/=b;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=40,b=8;
        System.out.println("Enter the no.");
        //num = in.nextInt();
        System.out.println("Enter the Base");
        //b = in.nextInt();
        Base_Conv ob=new Base_Conv();
        int conv=ob.AnyBaseConversion(num,b);
        System.out.println("Number= " + num + " \nNumebr after the base conversion number= " + conv);
    }
}
