package Recursion.BackTracking;
// Time Complexity: O(2^n * n)
// Space Complexity: O(n)
import java.util.*;

public class Subsequence_String {
    void solve(int idx,String st,String s,List<String>lt){
        if(idx==st.length()){
            lt.add(s);
            return;
        }
        solve(idx+1,st,s+st.charAt(idx),lt);   // take current character
        solve(idx+1,st,s,lt);                     // don't take current character
    }
    List<String> subsets(String st) {
        List<String> lt=new ArrayList<>();
        String s="";
        solve(0,st,s,lt);
        return lt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Subsequence_String ob = new Subsequence_String();
        String st="abc";
        List<String> res=ob.subsets(st);
        System.out.println(res);
    }
}
