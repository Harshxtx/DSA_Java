package Array;

import java.util.*;

public class Run_Len_Encoding {
    String compress(char[] chars) {
        int i,j=0,l=chars.length;
        String st="";
        char ch=' ';
        for(i=0;i<l;i++){
            st+=chars[i];
            int c=1;
            while(i<l-1 && chars[i]==chars[i+1]){
                c++;
                i++;
            }
            st+=String.valueOf(c);
        }
        return st;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Run_Len_Encoding ob = new Run_Len_Encoding();
        char ch[]=("aabbccc").toCharArray();
        String st=ob.compress(ch);
        System.out.println("String after compression: "+st);
    }
}
