package com.example.practice;

public class LinkedListPractice {
    public static void addTwoLinkedLists(LinkedList left, LinkedList right) {
        Node leftCur = left.head;
        Node rightCur = right.head;

        int remainder = 0;
        int digit = 1;
        int ans = 0; // put my answer here

        int leftVal, rightVal;
        while(leftCur != null || rightCur != null) {
            leftVal = leftCur == null ? 0 : leftCur.data;
            rightVal = rightCur == null ? 0 : rightCur.data;

            int sum = leftVal+ rightVal + remainder;
            if(sum > 10) {
                remainder = sum % 10;
                ans = leftCur.next == null && rightCur.next == null ? ans + digit * sum : ans + digit * remainder;
                remainder = remainder > 0 ? 1 : 0;
            } else {
                ans = ans + digit * sum;
                remainder = 0;
            }
            digit = digit * 10;

            if(leftCur != null) {
                leftCur = leftCur.next;
            }
            if(rightCur != null) {
                rightCur = rightCur.next;
            }
        }
        System.out.println(ans);
    }

    public static boolean checkPalindrome(LinkedList list) {
        // reverse the linked list
        Node n = list.head;

        LinkedList reverse = list.reverseLinkedList();

        Node reverseNode = reverse.head;
        Node originalNode = list.head;
        while(reverseNode != null) {
            if(reverseNode.data != originalNode.data) {
                return false;
            }
            reverseNode = reverseNode.next;
            originalNode = originalNode.next;
        }
        return true;
    }

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
//        list.appendToTail(10);

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
        addTwoLinkedLists(left, right);

        System.out.println();
        boolean isPaladrome = checkPalindrome(list);
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
