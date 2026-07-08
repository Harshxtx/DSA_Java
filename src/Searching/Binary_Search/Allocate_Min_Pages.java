package Searching.Binary_Search;

import java.util.*;

public class Allocate_Min_Pages {
    boolean isPossible(int pages[],long limit,int k){
        int i,l=pages.length;
        int st=1,curr_pg=0;
        for(i=0;i<l;i++){
            if(curr_pg+pages[i]<=limit){
                curr_pg+=pages[i];
            }
            else{
                st++;
                curr_pg=pages[i];
            }
        }
        return (st<=k);
    }
    public int findPages(int[] pages, int k) {
        int i,len=pages.length;
        if(k>len)
            return -1;
        int ans=0;
        long l=pages[0],r=0;
        for(i=0;i<len;i++){
            l=Math.max(l,pages[i]);
            r+=pages[i];
        }
        while(l<=r){
            long mid=l+(r-l)/2;
            if(isPossible(pages,mid,k)){
                ans=(int)mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Allocate_Min_Pages ob = new Allocate_Min_Pages();
        int arr[]={12, 34, 67, 90};
        int k=2;
        int res=ob.findPages(arr,k);
        System.out.println("The student with maximum no. allocation with minimum no. of pages: "+res);
    }
}
