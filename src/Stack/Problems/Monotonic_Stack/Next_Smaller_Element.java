package Stack.Problems;

import java.util.*;

public class Next_Smaller_Element {
    public int[] nextSmallerElement(int[] arr) {
        int i,l=arr.length;
        int ans[]=new int[l];
        Stack<Integer> st=new Stack<>();
        for(i=l-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=st.peek()){
                st.pop();
            }
            if(!st.isEmpty())
                ans[i]=st.peek();
            else
                ans[i]=-1;
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Next_Smaller_Element ob = new Next_Smaller_Element();
        int arr[]={4, 8, 5, 2, 25};
        int res[]=ob.nextSmallerElement(arr);
        System.out.println("Result: "+Arrays.toString(res));
    }
}
