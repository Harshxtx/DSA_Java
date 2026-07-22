package Heap.Problems;

import java.util.*;

public class Sort_Characters_By_Frequency {
    String frequencySort(String s) {
        HashMap<Character, Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue((a,b) -> mp.get(b)-mp.get(a));
        for(char ch: mp.keySet()){
            pq.offer(ch);
        }
        StringBuilder st=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int n=mp.get(ch);
            for(int i=0;i<n;i++){
                st.append(ch);
            }
        }
        return st.toString();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sort_Characters_By_Frequency ob = new Sort_Characters_By_Frequency();
        String st="character";
        System.out.println("Original String: "+st);
        String res=ob.frequencySort(st);
        System.out.println("Sorted String by character frequency: "+res);
    }
}
