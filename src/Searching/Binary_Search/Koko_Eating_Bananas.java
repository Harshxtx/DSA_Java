package Searching.Binary_Search;

import java.util.*;

public class Koko_Eating_Bananas {
    int minEatingSpeed(int[] piles, int h) {
        int i,l=piles.length,min=1,max=0,s=0,m;
        for(i=0;i<l;i++)
        {
            max=Math.max(max,piles[i]);
        }
        while(min<max)
        {
            s=0;
            m=(max+min)/2;
            for(i=0;i<l;i++)
            {
                s=s+(piles[i]/m);
                if(piles[i]%m!=0)
                    s++;
            }
            if(s<=h)
                max=m;
            else
                min=m+1;
        }
        return min;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Koko_Eating_Bananas ob = new Koko_Eating_Bananas();
        int arr[]={30,11,23,4,20};
        int hour=5;
        int speed= ob.minEatingSpeed(arr,hour);
        System.out.println("Minimum speed require to eat all bananas in "+hour+"hrs is: "+speed);
        hour=6;
        speed= ob.minEatingSpeed(arr,hour);
        System.out.println("Minimum speed require to eat all bananas in "+hour+"hrs is: "+speed);
    }
}
