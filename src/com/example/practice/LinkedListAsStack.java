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

    public static void main(String[] args) {
        LinkedListAsStack l1 = new LinkedListAsStack();
        l1.push(1); l1.head.printNodes();
        l1.push(2); l1.head.printNodes();
        l1.push(3); l1.head.printNodes();
        l1.push(4); l1.head.printNodes();
        l1.push(5); l1.head.printNodes();
        System.out.println();
        l1.pop(); l1.head.printNodes();
        l1.pop(); l1.head.printNodes();
        l1.pop(); l1.head.printNodes();
        l1.pop(); l1.head.printNodes();
        l1.pop();
    }
}
