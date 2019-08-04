package com.Ch03.StackAndQueue;

import java.util.Stack;

public class StackSort {


    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(23);
        st.push(3);
        st.push(50);
        st.push(15);
        sort(st);

        System.out.println(st.peek());

    }

    static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();

        while (!s.isEmpty()) {
            Integer top = s.pop();

            while (!r.isEmpty() && r.peek() > top) {
                s.push(r.pop());
            }
            r.push(top);
        }


        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

}
