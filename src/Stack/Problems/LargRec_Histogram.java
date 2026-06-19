package Stack.Problems;

import java.util.*;

public class LargRec_Histogram {
    public int largestRectangleArea(int[] arr) {
        int i,len=arr.length,area=0;
        Stack<Integer> st=new Stack<>();
        for(i=0;i<=len;i++){
            int val=i==len?0:arr[i];
            while(!st.isEmpty() && arr[st.peek()]>val){
                int h=arr[st.pop()];
                int w;
                if(st.isEmpty())
                    w=i;
                else
                    w=i-st.peek()-1;
                area=(int)Math.max(area,h*w);
            }
            st.push(i);
        }
        return area;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        LargRec_Histogram ob = new LargRec_Histogram();
        int arr[]={2,1,5,6,2,3};
        int res=ob.largestRectangleArea(arr);
        System.out.println("The largest area of rectangle in histogram: "+res);
    }
}
