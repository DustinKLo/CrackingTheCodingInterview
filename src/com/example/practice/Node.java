package com.example.practice;

import java.util.ArrayList;

public class Node {
    Node next;
    int data;

    public Node(int d) {
        data = d;
    }

    public void appendTail(Node newNode) {
        this.next = newNode;
    }

    public void printNodes() {
        Node cur = this;
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
}
