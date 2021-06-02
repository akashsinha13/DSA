package dsa.stack;

import java.util.Stack;

public class MinStackWithoutExtraSpace {
    public static void main(String[] args) {
        MinStackImpl ms = new MinStackImpl();
        ms.push(5);
        ms.push(6);
        ms.push(4);
        ms.push(1);
        System.out.println("Min element is " + ms.getMin());
        ms.pop();
        System.out.println("Min element is " + ms.getMin());
        ms.pop();
        System.out.println("Min element is " + ms.getMin());

    }
}


class MinStackImpl {
    Stack<Integer> s;
    int min;

    MinStackImpl() {
        s = new Stack<>();
        min = 0;
    }

    public void push(int num) {
        if (s.isEmpty()) {
            min = num;
            s.push(num);
        } else if (num < min) {
            int val = 2 * num - min;
            min = num;
            s.push(val);
        }
    }

    public int pop() {
        if (s.peek() < min) {
            int num = min;
            min = 2 * min - s.peek();
            s.pop();
            return num;
        } else {
            return s.pop();
        }
    }

    public int top() {
        if (s.peek() < min) {
            return min;
        }
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}