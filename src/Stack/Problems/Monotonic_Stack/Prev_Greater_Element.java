package Stack.Problems;

import java.util.*;

public class Prev_Greater_Element {public int[] prevGreaterElement(int[] arr) {
    int i,l=arr.length;
    int ans[]=new int[l];
    Stack<Integer> st=new Stack<>();
    for(i=0;i<l;i++){
        while(!st.isEmpty() && st.peek()<=arr[i]){
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
        Prev_Greater_Element ob = new Prev_Greater_Element();
        int arr[]={15, 10, 18, 12, 4, 6, 2, 8};
        int res[]=ob.prevGreaterElement(arr);
        System.out.println("Result: "+Arrays.toString(res));
    }
}
