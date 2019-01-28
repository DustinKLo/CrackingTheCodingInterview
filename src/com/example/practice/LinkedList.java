package com.example.practice;

public class LinkedList {
    Node head = null;
    Node tail = null;

    //add node to end of linkedlist
    public void appendToTail(int d) {
        Node temp = new Node(d);

        if (head == null) {
            head = temp;
            head.next = tail;
            tail = head;
        } else {
            tail.next = temp; //making new node as the new tail
            tail = tail.next; // giving the new node the title as tail
        }
    }

    public void printLinkedList() {
        Node cur = head;
        while(cur != null) {
            if(cur.next != null) {
                String str = String.format("%2d -> ", cur.data);
                System.out.print(str);
            } else {
                System.out.print(cur.data);
            }
            cur = cur.next;
        }
        System.out.println("");
    }

    public LinkedList mergeLinkedLists(LinkedList left, LinkedList right) {
        left.tail.next = right.head; // make the left tail point to head
        left.tail = right.tail; // label the left tail as the right tail

        left.printLinkedList();
        return left;
    }

    public void partitionLinkedList(int k) {
        // k is the divider (or divider)
        LinkedList lower = new LinkedList();
        LinkedList upper = new LinkedList();

        Node cur = head;
        while(cur != null) {
            if(cur.data < k) {
                lower.appendToTail(cur.data);
            } else {
                upper.appendToTail(cur.data);
            }
            cur = cur.next;
        }
        mergeLinkedLists(lower, upper);
    }
}
