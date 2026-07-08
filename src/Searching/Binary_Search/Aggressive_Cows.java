package Searching.Binary_Search;

import java.util.*;

public class Aggressive_Cows {
    boolean isPossible(int arr[],int dist,int k){
        int countcows=1,last=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]-last>=dist){
                countcows++;
                last=arr[i];
            }
        }
        return (countcows>=k);
    }
    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int l=1,r=arr[arr.length-1]-arr[0];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(arr,mid,k)){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return r;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Aggressive_Cows ob = new Aggressive_Cows();
        int arr[]={10, 1, 2, 7, 5};
        int k=3;
        int dis= ob.aggressiveCows(arr,k);
        System.out.println("The maximum possible minimum distance is:"+dis);
    }
}
