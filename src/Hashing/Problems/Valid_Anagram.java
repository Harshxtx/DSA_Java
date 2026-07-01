package Hashing.Problems;

import java.util.*;

public class Valid_Anagram {
    boolean validAnagram(String s,String t){
        HashMap<Character, Integer> map=new HashMap<>();
        if(s.length()!=t.length())
            return false;
        int i,l=s.length();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        for(int n:map.values()){
            if(n!=0)
                return false;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Valid_Anagram ob = new Valid_Anagram();
        String s="anagram";
        String t="nagaram";
        if(ob.validAnagram(s,t)){
            System.out.println("Valid Anagram");
        }
        else {
            System.out.println("Invalid Anagram");
        }
    }
}
