package dsa.stack;

import java.util.Stack;

public class MinStackImplWithExtraSpace {
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(6);
        ms.push(1);
        System.out.println("Min element is " + ms.getMin());
        ms.pop();
        System.out.println("Min element is " + ms.getMin());

    }
}

class MinStack {
    Stack<Integer> s;
    Stack<Integer> temp;

    MinStack() {
        s = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int num) {
        if (s.isEmpty()) {
            temp.push(num);
        } else if (num < temp.peek()) {
            temp.push(num);
        }
        s.push(num);
    }

    public int pop() {
        if (s.peek() == temp.peek()) {
            temp.pop();
        }
        return s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return temp.peek();
    }
}
