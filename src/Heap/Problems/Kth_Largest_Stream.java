package Heap.Problems;

import java.util.*;

public class Kth_Largest_Stream {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size()<min.size())
            max.offer(min.poll());
    }
    public double findMedian() {
        if(max.size()>min.size())
            return max.peek();
        else
            return (min.peek()+max.peek())/2.0;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Kth_Largest_Stream ob = new Kth_Largest_Stream();
        ob.addNum(1);                           // arr = [1]
        ob.addNum(2);                           // arr = [1, 2]
        System.out.println(ob.findMedian());    // return 1.5 (i.e., (1 + 2) / 2)
        ob.addNum(3);                           // arr[1, 2, 3]
        System.out.println(ob.findMedian());    // return 2.0
    }
}
