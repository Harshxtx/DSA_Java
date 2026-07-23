package Heap.Problems;

import java.util.*;

public class Median_From_Data_Stream {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public void addNum(int num) {
        if(max.isEmpty() || max.peek()>num)
            max.offer(num);
        else
            min.offer(num);

        balance();
    }
    void balance(){
        if(max.size()>min.size()+1)
            min.offer(max.poll());
        else if(max.size()<min.size()-1)
            max.offer(min.poll());
    }
    public double findMedian() {

        if(max.size()>min.size())
            return max.peek();
        else if(max.size()<min.size())
            return min.peek();
        else
            return (min.peek()+max.peek())/2.0;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Median_From_Data_Stream ob = new Median_From_Data_Stream();
        ob.addNum(1);                           // arr = [1]
        ob.addNum(2);                           // arr = [1, 2]
        System.out.println(ob.findMedian());    // return 1.5 (i.e., (1 + 2) / 2)
        ob.addNum(3);                           // arr[1, 2, 3]
        System.out.println(ob.findMedian());    // return 2.0
    }
}
