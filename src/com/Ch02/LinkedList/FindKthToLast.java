package com.Ch02.LinkedList;

import com.util.AssortedMethods;
import com.util.LinkedListNode;

public class FindKthToLast {

    public static LinkedListNode nthToLast(LinkedListNode head, int k){
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for(int i =0;i<k;i++){
            if(p1.next!=null){
                p1 = p1.next;
            }
        }
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }


    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            LinkedListNode node = nthToLast(head, i);
            String nodeValue = node == null ? "null" : "" + node.data;
            System.out.println(i + ": " + nodeValue);
        }
    }
}
