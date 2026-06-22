package Queue.Problems;

import java.util.*;

public class Sliding_Win_Max {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int i,j=0,l=arr.length,max=arr[0];
        Deque<Integer> q=new ArrayDeque<>();
        int ans[]=new int[l-k+1];
        for(i=0;i<l;i++){
            if(!q.isEmpty() && q.peekFirst()<=i-k)
                q.pollFirst();
            while(!q.isEmpty() && arr[i]>arr[q.peekLast()])
                q.pollLast();

            q.addLast(i);
            if(i>=k-1)
                ans[j++]=arr[q.peekFirst()];
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sliding_Win_Max ob = new Sliding_Win_Max();
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=ob.maxSlidingWindow(arr,k);
        System.out.println("Resultant: "+Arrays.toString(res));
    }
}
