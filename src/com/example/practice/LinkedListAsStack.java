package com.example.practice;

public class LinkedListAsStack {
    private Node head = null;
    private Node tail = null;

    private void push(int d) {
        Node temp = new Node(d);
        if(head == null) {
            head = temp;
            head.next = tail;
            tail = head;
        } else {
            tail.next = temp; // making new node as the new tail
            tail = tail.next; // giving the new node the title as tail
        }
    }

    private int pop() {
        if (head == null)
            throw new NullPointerException("Stack is empty");
        else if (head.next == null) {
            Node temp = head;
            head = null;
            return temp.data;
        } else {
            Node temp = head;
            head = temp.next;
            return temp.data;
        }
    }

    private void printLinkedList() {
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
        // System.out.println();
    }

    public static void main(String[] args) {
        LinkedListAsStack l1 = new LinkedListAsStack();
        for (int i = 0; i <= 15; i ++) {
            l1.push(i); l1.printLinkedList(); System.out.println();
        }
        System.out.println();
        while (l1.head != null) {
            l1.pop(); l1.printLinkedList(); System.out.println();
        }
    }
}
