package Stack.Problems;

import java.util.*;
class LongestValid_Parantheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int i,l=s.length(),max=0;
        for(i=0;i<l;i++)
        {
            char ch=s.charAt(i);
            if(s.charAt(i)=='(')
                st.push(i);
            else
            {
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else
                    max=Math.max(max,i-st.peek());
            }
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        LongestValid_Parantheses ob = new LongestValid_Parantheses();
        String ss="(())(()())";
        System.out.println("Longest length of a valid parantheses is: "+ob.longestValidParentheses(ss));

    }
}
