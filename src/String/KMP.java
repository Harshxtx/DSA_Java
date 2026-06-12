package String;

import java.util.*;
public class KMP {
    int[] compute(char[] pat){
        int []lps=new int[pat.length];
        int i=1,j=0;
        while(i<pat.length){
            if(pat[i]==pat[j]){
                lps[i]=j+1;
                j++;
                i++;
            }
            else{
                if(j!=0)
                    j=lps[j-1];
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    int KMP(String t,String p) {
        char text[] = t.toCharArray();
        char pat[] = p.toCharArray();
        int i = 0, j = 0;
        int[] lps = compute(pat);

        while (i < text.length && j < pat.length) {
            if (text[i] == pat[j]) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        if (j == pat.length)
            return (i - pat.length);
        return -1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        KMP ob = new KMP();
        String text="sadbutsad";
        String pattern="sad";
        int n=ob.KMP(text,pattern);
        if(n!=-1)
            System.out.println("Pattern found at index: "+n);
        else
            System.out.println("Not found");
    }
}
