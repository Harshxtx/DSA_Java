package Hashing.Problems.Subarray;

import java.util.*;

public class Lar_Sub_0 {
    boolean findsum(int nums[]) {
        int i,l=nums.length;
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        set.add(0);
        for(i=0;i<l;i++){
            sum+=nums[i];
            if(set.contains(sum))
                return true;
            else
                set.add(sum);
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Lar_Sub_0 ob = new Lar_Sub_0();
        int[] arr ={15, -2, 2, -8, 1, 7, 10, 23};
        if(ob.findsum(arr))
            System.out.println("There is a subarray with sum 0");
        else
            System.out.println("No subarray with sum 0 is present");
    }
}
