package com.Ch03.StackAndQueue;

import java.util.Stack;

public class StackMin extends Stack<Integer> {

    Stack<Integer> s;

    public StackMin(Stack<Integer> s) {
        this.s = s;
    }

    void push(int value) {
        if (value <= min()) {
            s.push(value);
        }
        super.push(value);

    }

    public Integer pop() {

        int value = super.pop();
        if (value == s.peek()) {
            s.pop();
        }

        return value;
    }

    int min() {
        if (s.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s.peek();
        }
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        StackMin stMin = new StackMin(s);
        stMin.push(34);
        stMin.push(12);
        stMin.push(18);
        stMin.push(65);
        stMin.push(54);

        System.out.println(stMin.min());

    }

}
