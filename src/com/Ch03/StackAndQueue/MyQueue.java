package com.Ch03.StackAndQueue;

import java.util.Stack;


// Solution 4 :- Queue implemented using two Stacks.
public class MyQueue<T> {

    Stack<T> oldStack, newStack;

    public MyQueue(Stack<T> oldStack, Stack<T> newStack) {
        this.oldStack = oldStack;
        this.newStack = newStack;
    }

    void add(T value) {
        newStack.push(value);
    }

    void shiftStack() {
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }
    }

    T remove() {
        shiftStack();
        return oldStack.pop();

    }

    T peek() {
        shiftStack();
        return oldStack.peek();
    }

    public static void main(String[] args) {

        Stack<Integer> oldStack = new Stack<>();
        Stack<Integer> newStack = new Stack<>();
        MyQueue queue = new MyQueue(oldStack, newStack);
        queue.add(5);
        queue.add(6);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.peek());
    }


}

