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

    public void prependToHead(int d) {
        Node temp = new Node(d);

        if(head == null) {
            head = temp;
            head.next = tail;
            tail = head;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public LinkedList reverseLinkedList() {
        // reverse the linked list
        Node n = this.head;

        LinkedList reverse = new LinkedList();
        while(n != null) {
            reverse.prependToHead(n.data);
            n = n.next;
        }
        return reverse;
    }

    public Node reverseLinkedListPerm() {
        if(head == null || head.next == null) {
            return head; // linked list of length 1
        }

        Node prev = head;
        Node cur = head.next;
        prev.next = null;

        while(cur != null) {
            Node temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }
        head = prev;
        return head;

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
        System.out.println();
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
