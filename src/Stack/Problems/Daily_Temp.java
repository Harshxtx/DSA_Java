package Stack.Problems;

import java.util.*;

public class Daily_Temp {
    public int[] dailyTemperatures(int[] temp) {
        int i,l=temp.length;
        int arr[]=new int[l];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(i=1;i<l;i++)
        {
            while(!st.isEmpty() && temp[st.peek()]<temp[i])
            {
                arr[st.peek()]=i-st.pop();
            }
            st.push(i);
        }
        return arr;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Daily_Temp ob = new Daily_Temp();
        int arr[]={73,74,75,71,69,72,76,73};
        int res[]=ob.dailyTemperatures(arr);
        System.out.println("Result: "+Arrays.toString(res));
    }
}
