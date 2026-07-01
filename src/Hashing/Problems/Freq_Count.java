package Hashing.Problems;

import java.util.*;

public class Freq_Count {
    Map<Integer, Integer> freqCount(int arr[]){
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return map;
    }
    void display(Map<Integer, Integer> map){
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            System.out.println(e.getKey()+"->"+e.getValue());
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Freq_Count ob=new Freq_Count();
        int arr[]={1,2,1,3,2,1};
        Map<Integer, Integer> map=ob.freqCount(arr);
        ob.display(map);
    }
}
