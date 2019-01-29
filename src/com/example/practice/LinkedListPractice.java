package com.example.practice;

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
    }
}
