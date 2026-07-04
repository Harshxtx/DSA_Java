package Recursion;
//Time complexity: O(2^n)
import java.util.*;

public class Tower_Of_Hanoi {
    int i=1;
    void towerOfHanoi(int n, char src, char helper, char des){
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, src, des, helper);
        System.out.println((i++)+"). Disk " + n + " moved from "+src+" to "+des);
        towerOfHanoi(n - 1, helper, src, des);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Tower_Of_Hanoi ob = new Tower_Of_Hanoi();
        int n=3;
        int min_moves=(int)Math.pow(2,n)-1;                 //min no. of moves to solve it
        ob.towerOfHanoi(n, 'A', 'B', 'C');
    }
}
