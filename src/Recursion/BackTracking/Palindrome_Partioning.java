package Recursion.BackTracking;

import java.util.*;

public class Palindrome_Partioning {
    boolean isPalin(String st,int l,int u){
        while(l<u){
            if(st.charAt(l)!=st.charAt(u))
                return false;
            l++;
            u--;
        }
        return true;
    }
    void part(int idx,String st,List<List<String>> ans,List<String> ds){
        if(idx==st.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<st.length();i++){
            if(isPalin(st,idx,i)){
                ds.add(st.substring(idx,i+1));
                part(i+1,st,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        part(0,s,res,new ArrayList<>());
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Palindrome_Partioning ob = new Palindrome_Partioning();
        String st="aabb";
        List<List<String>> res=ob.partition(st);
        for(List<String> lt:res)
        System.out.println(lt);
    }
}
