package com.example.practice;

import java.util.*;
import java.util.Random;


public class LinkedList {
    Node head = null;
    Node tail = null;

    ArrayList<Node> cache = new ArrayList<Node>();
    int cacheSize;

    public void appendToTail(int d) { // add node to end of linkedlist
        Node temp = new Node(d);

        if (head == null) {
            head = temp;
            head.next = tail;
            tail = head;
        } else {
            tail.next = temp; // making new node as the new tail
            tail = tail.next; // giving the new node the title as tail
        }
        cache.add(temp);
        cacheSize++;
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
        cache.add(temp);
        cacheSize++;
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

    public void reverseLinkedListPerm() {
        if(head == null || head.next == null) {
            return; // linked list of length 1
        }

        Node prev = head;
        Node cur = head.next;
        prev.next = null;
        tail = prev;

        while(cur != null) {
            Node temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }
        head = prev;
        return;

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

    public LinkedList partitionLinkedList(int k) {
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
        return mergeLinkedLists(lower, upper);
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

    public static int addTwoLinkedLists(LinkedList left, LinkedList right) {
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
        return ans;
    }

    public int getCacheSize() {
//        System.out.println(cacheSize);
        return cacheSize;
    }

    public void pointRandom() {
        int randomCacheIndex = (int)(Math.random() * this.getCacheSize() - 1);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        System.out.println(cache.get((int)(Math.random() * this.getCacheSize())).data);
        return;
    }
}
