package com.example.practice;
import java.util.*;

public class LinkedListPractice {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(5);
        list.appendToTail(4);
        list.appendToTail(3);
        list.appendToTail(2);
        list.appendToTail(1);

        list.printLinkedList();
        LinkedList reversedLinkedList = list.reverseLinkedList();
        reversedLinkedList.printLinkedList();
        System.out.println();

        list.partitionLinkedList(3);

        LinkedList left = new LinkedList();
        left.appendToTail(7);
        left.appendToTail(1);
        left.appendToTail(6);
        left.appendToTail(9);

        LinkedList right = new LinkedList();
        right.appendToTail(5);
        right.appendToTail(9);
        right.appendToTail(2);
        right.appendToTail(7);

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
        list2.appendToTail(1);
        list2.appendToTail(2);
        list2.appendToTail(3);
        list2.appendToTail(4);
        list2.appendToTail(5);
        list2.printLinkedList();
        list2.reverseLinkedListPerm();
        list2.printLinkedList();
        list2.reverseLinkedListPerm();
        list2.printLinkedList();


        System.out.println();
        Node n1 = new Node(1);
        Node n2 = new Node(2); n1.appentTail(n2);
        Node n3 = new Node(3); n2.appentTail(n3);
        Node n4 = new Node(4); n3.appentTail(n4);
        Node n5 = new Node(5); n4.appentTail(n5);
        Node n6 = new Node(6); n5.appentTail(n6);
        Node n7 = new Node(7); n6.appentTail(n7);

        Node a1 = new Node(10);
        Node a2 = new Node(11); a1.appentTail(a2);
        Node a3 = new Node(12); a2.appentTail(a3);
        a3.appentTail(n7);

        System.out.println("1 ->  2 ->  3 ->  4 ->  5 ->  6 -> 7\n" +
                "                        ^\n" +
                "                        |\n" +
                "      10-> 11->  12 ----|");

        System.out.println();
        LinkedList.findIntersection(n1, a1);

        System.out.println();
        Node b1 = new Node(1);
        Node b2 = new Node(2); b1.appentTail(b2);
        Node b3 = new Node(3); b2.appentTail(b3);
        Node b4 = new Node(3); b3.appentTail(b4);
        Node b5 = new Node(4); b4.appentTail(b5);
        Node b6 = new Node(5); b5.appentTail(b6);
        Node b7 = new Node(5); b6.appentTail(b7);
        Node b8 = new Node(7); b7.appentTail(b8);
        b1.printNodes();

        System.out.println();
        LinkedList list3 = new LinkedList();
        list3.appendToTail(0);
        list3.appendToTail(1);
        list3.appendToTail(2);
        list3.appendToTail(2);
        list3.appendToTail(3);
        list3.appendToTail(4);
        list3.appendToTail(4);
        list3.appendToTail(5);
        list3.appendToTail(6);
        list3.appendToTail(7);
        list3.appendToTail(8);
        list3.appendToTail(9);
        list3.printLinkedList();
        list3.removeDuplicates();
        list3.printLinkedList();

        list3.kthToLast(3);
    }
}
