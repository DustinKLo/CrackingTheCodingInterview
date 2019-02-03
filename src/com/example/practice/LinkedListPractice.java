package com.example.practice;
import java.util.*;

public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node a1 = new Node(1); list.appendToTail(a1);
        Node a2 = new Node(2); list.appendToTail(a2);
        Node a3 = new Node(3); list.appendToTail(a3);
        Node a4 = new Node(4); list.appendToTail(a4);
        Node a5 = new Node(5); list.appendToTail(a5);
        Node a6 = new Node(4); list.appendToTail(a6);
        Node a7 = new Node(3); list.appendToTail(a7);
        Node a8 = new Node(2); list.appendToTail(a8);
        Node a9 = new Node(1); list.appendToTail(a9);

        list.printLinkedList();
        LinkedList reversedLinkedList = list.reverseLinkedList();
        reversedLinkedList.printLinkedList();
        System.out.println();

        list.partitionLinkedList(3);

        LinkedList left = new LinkedList();
        Node b1 = new Node(7); left.appendToTail(b1);
        Node b2 = new Node(1); left.appendToTail(b2);
        Node b3 = new Node(6); left.appendToTail(b3);
        Node b4 = new Node(9); left.appendToTail(b4);

        LinkedList right = new LinkedList();
        Node c1 = new Node(5); right.appendToTail(c1);
        Node c2 = new Node(9); right.appendToTail(c2);
        Node c3 = new Node(2); right.appendToTail(c3);
        Node c4 = new Node(7); right.appendToTail(c4);

        System.out.println();
        left.printLinkedList();
        right.printLinkedList();
        LinkedList.addTwoLinkedLists(left, right);

        System.out.println();
        boolean isPaladrome = LinkedList.checkPalindrome(list);
        if(isPaladrome) {
            System.out.println("linked list IS a palindrome");
        } else {
            System.out.println("linked list IS NOT a palindrome");
        }

        LinkedList list2 = new LinkedList();
        Node d1 = new Node(1); list2.appendToTail(d1);
        Node d2 = new Node(2); list2.appendToTail(d2);
        Node d3 = new Node(3); list2.appendToTail(d3);
        Node d4 = new Node(4); list2.appendToTail(d4);
        Node d5 = new Node(5); list2.appendToTail(d5);
        list2.printLinkedList();
        list2.reverseLinkedListPerm();
        list2.printLinkedList();
        list2.reverseLinkedListPerm();
        list2.printLinkedList();


        System.out.println();
        Node e1 = new Node(1);
        Node e2 = new Node(2); e1.appendTail(e2);
        Node e3 = new Node(3); e2.appendTail(e3);
        Node e4 = new Node(4); e3.appendTail(e4);
        Node e5 = new Node(5); e4.appendTail(e5);
        Node e6 = new Node(6); e5.appendTail(e6);
        Node e7 = new Node(7); e6.appendTail(e7);

        Node f1 = new Node(10);
        Node f2 = new Node(11); f1.appendTail(f2);
        Node f3 = new Node(12); f2.appendTail(f3);
        f3.appendTail(e7);

        System.out.println("1 ->  2 ->  3 ->  4 ->  5 ->  6 -> 7\n" +
                "                        ^\n" +
                "                        |\n" +
                "      10-> 11->  12 ----|");

        System.out.println();
        LinkedList.findIntersection(e1, f1);


        System.out.println();
        Node g1 = new Node(1);
        Node g2 = new Node(2); g1.appendTail(g2);
        Node g3 = new Node(3); g2.appendTail(g3);
        Node g4 = new Node(3); g3.appendTail(g4);
        Node g5 = new Node(4); g4.appendTail(g5);
        Node g6 = new Node(5); g5.appendTail(g6);
        Node g7 = new Node(5); g6.appendTail(g7);
        Node g8 = new Node(7); g7.appendTail(g8);
        g1.printNodes();

        System.out.println();
        LinkedList list3 = new LinkedList();
        Node h1 = new Node(0); list3.appendToTail(h1);
        Node h2 = new Node(1); list3.appendToTail(h2);
        Node h3 = new Node(2); list3.appendToTail(h3);
        Node h4 = new Node(2); list3.appendToTail(h4);
        Node h5 = new Node(4); list3.appendToTail(h5);
        Node h6 = new Node(4); list3.appendToTail(h6);
        Node h7 = new Node(6); list3.appendToTail(h7);
        Node h8 = new Node(7); list3.appendToTail(h8);
        Node h9 = new Node(8); list3.appendToTail(h9);
        Node h10 = new Node(8); list3.appendToTail(h10);
        Node h11 = new Node(10); list3.appendToTail(h11);
        Node h12 = new Node(10); list3.appendToTail(h12);
        list3.printLinkedList();
        list3.removeDuplicates();
        list3.printLinkedList();

        System.out.println();
        System.out.println(list3.kthToLast(3).data);

        LinkedList list4 = new LinkedList();
        Node j1 = new Node(1); list4.appendToTail(j1);
        Node j2 = new Node(2); list4.appendToTail(j2);
        Node j3 = new Node(3); list4.appendToTail(j3);
        Node j4 = new Node(4); list4.appendToTail(j4);
        Node j5 = new Node(5); list4.appendToTail(j5);
        Node j6 = new Node(6); list4.appendToTail(j6);
        Node j7 = new Node(7); list4.appendToTail(j7);
        Node j8 = new Node(8); list4.appendToTail(j8);
        Node j9 = new Node(9); list4.appendToTail(j9);
        list4.appendToTail(j4);
    }
}
