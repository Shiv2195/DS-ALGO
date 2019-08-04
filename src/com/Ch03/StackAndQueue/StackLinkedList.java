package com.Ch03.StackAndQueue;

import java.util.EmptyStackException;

public class StackLinkedList<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;


        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode node = new StackNode(item);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {

        StackLinkedList<Integer> s = new StackLinkedList<>();
        s.push(23);
        s.push(35);

        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());

    }

}
