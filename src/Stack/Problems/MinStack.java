package Stack.Problems;

import java.util.*;
class MinStack {
    Stack<Integer> alldata;
    Stack<Integer> mindata;
    public MinStack() {
        alldata=new Stack<>();
        mindata=new Stack<>();
    }

    public void push(int value) {
        alldata.push(value);
        if(mindata.isEmpty() || mindata.peek()>=value)
            mindata.push(value);
    }

    public int pop() {
        int val=alldata.pop();
        if(val==mindata.peek())
            mindata.pop();
        return val;
    }

    public int top() {
        return alldata.peek();
    }

    public int getMin() {
        return mindata.peek();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        System.out.println(minStack.pop());    // return -3
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin());    // return -2

    }
}
