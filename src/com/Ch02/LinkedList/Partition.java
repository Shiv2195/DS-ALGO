package com.Ch02.LinkedList;

import com.util.LinkedListNode;

public class Partition {

    public  static LinkedListNode partition(LinkedListNode node,int value){
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while(node!=null){
            LinkedListNode next = node.next;
            if( node.data < value){
               node.next = head;
               head= node;
            }
            else{
                tail.next = node ;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }


    public static void main(String[] args) {
        int length = 20;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());

        LinkedListNode h = partition(head, 8);
        System.out.println(h.printForward());
    }

}
