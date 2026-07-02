package Hashing.Problems;

import java.util.*;

public class Contains_Duplicate {
    boolean hasDuplicate(int[] arr){
        Set<Integer> set=new HashSet<>();
        for(int num:arr){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Contains_Duplicate ob = new Contains_Duplicate();
        int arr[]={1,2,3,1};
        if(ob.hasDuplicate(arr))
            System.out.println("Conatins Duplicate");
        else
            System.out.println("Does not contain Duplicate");
    }
}
