package Heap.Problems;

import java.util.*;

public class Reorganize_String {
    class Pair{
        int freq;
        char ch;
        Pair(int freq,char ch){
            this.freq=freq;
            this.ch=ch;
        }
    }
    public String reorganizeString(String s) {
        int l=s.length();
        int arr[]=new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
            if(arr[ch-'a']>(l+1)/2)
                return "";
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> b.freq-a.freq);
        for(char ch='a' ;ch<='z';ch++){
            if(arr[ch-'a']>0){
                pq.add(new Pair(arr[ch-'a'],ch));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(pq.size()>1){
            Pair p1=pq.poll();
            Pair p2=pq.poll();
            sb.append(p1.ch);
            sb.append(p2.ch);
            p1.freq--;
            p2.freq--;
            if(p1.freq>0)
                pq.offer(p1);
            if(p2.freq>0)
                pq.offer(p2);

        }
        if(!pq.isEmpty()){
            sb.append(pq.poll().ch);
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Reorganize_String ob = new Reorganize_String();
        String st="apps";
        System.out.println("Original String: "+st);
        String res=ob.reorganizeString(st);
        if(res.isEmpty()){
            System.out.println("Cannot reorganize string");
        }
        else {
            System.out.println("Reorganized String: "+res);
        }
    }
}
