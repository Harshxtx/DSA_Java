package Stack.Problems;

import java.util.*;
class Valid_Parantheses2 {
    public boolean isValid(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> star=new Stack<>();
        int i,l=s.length();
        for(i=0;i<l;i++)
        {
            char t=s.charAt(i);
            if(t=='(')
                st.push(i);
            else if(t=='*')
                star.push(i);
            else{
                if(!st.isEmpty())
                    st.pop();
                else if(!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }
        while(!st.isEmpty() && !star.isEmpty())
            if(st.pop()>star.pop())
                return false;
        return st.isEmpty();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Valid_Parantheses2 ob = new Valid_Parantheses2();
        String ss="(*()*))";
        //String ss="()((*";
        if(ob.isValid(ss))
            System.out.println("Given parantheses are valid");
        else
            System.out.println("Given parantheses are not valid");
    }
}
