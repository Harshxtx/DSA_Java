package Recursion.BackTracking;

import java.util.*;

public class Generate_Paranthesis {
    void gen(List<String> st,int op,int cl,String s,int n)
    {
        if(s.length()==n*2)
        {
            st.add(s);
            return;
        }
        if(op<n)
            gen(st,op+1,cl,s+"(",n);    // choose open bracket
        if(cl<op)               //close brackets cannot exceed open brackets
            gen(st,op,cl+1,s+")",n);    // choose close bracket
    }
    public List<String> generateParenthesis(int n) {
        List<String> st=new ArrayList<>();
        gen(st,0,0,"",n);
        return st;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Generate_Paranthesis ob = new Generate_Paranthesis();
        int n=3;
        List<String> lt=ob.generateParenthesis(n);
        System.out.println(lt);
    }
}
