package Stack.Problems;

import java.util.*;
class Valid_Parantheses {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i,j,l=s.length();
        char ch;
        for(i=0;i<l;i++)
        {
            char t=s.charAt(i);
            if(t=='(' || t=='{' || t=='[')
                st.push(t);
            else if(!st.isEmpty())
            {
                char x=st.peek();
                if((t==')' && x=='(') || (t=='}' && x=='{') || (t==']' && x=='['))
                    st.pop();
                else
                    return false;
            }
            else
                return false;
        }
        return st.isEmpty();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Valid_Parantheses ob = new Valid_Parantheses();
        String ss="()[]{}";
        //String ss="([)]";
        if(ob.isValid(ss))
            System.out.println("Given parantheses are valid");
        else
            System.out.println("Given parantheses are not valid");
    }
}
