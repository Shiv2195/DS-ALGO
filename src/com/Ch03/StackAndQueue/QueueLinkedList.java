package com.Ch03.StackAndQueue;

import java.util.NoSuchElementException;

public class QueueLinkedList<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> front;
    private QueueNode<T> rear;

    public void add(T item) {
        QueueNode<T> node = new QueueNode(item);
        if (rear != null) {
            rear.next = node;
        }
        rear = node;

        if (front == null) {
            front = rear;
        }
    }

    public T remove() {
        if (front == null) throw new NoSuchElementException();
        T data = front.data;
        front = front.next;
        if (front == rear) {
            rear = null;
        }
        return data;
    }

    public T peek(){
        if(front==null) throw new NoSuchElementException();
        return front.data;
    }

    public boolean isEmpty(){
        return front==null;
    }

    public static void main(String[] args) {
        QueueLinkedList<Integer> qu = new QueueLinkedList<>();
        qu.add(34);
        qu.add(56);
        qu.add(23);
        System.out.println(qu.peek());
        System.out.println(qu.remove());
        System.out.println(qu.isEmpty());
        System.out.println(qu.rear.data);

    }

}
