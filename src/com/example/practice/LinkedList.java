package com.example.practice;

import java.util.*;
import java.util.Random;


public class LinkedList {
    Node head = null;
    Node tail = null;

    public void appendToTail(Node d) { // add node to end of linkedlist
//        Node temp = new Node(d);

        if (head == null) {
            head = d;
            head.next = tail;
            tail = head;
        } else {
            tail.next = d; // making new node as the new tail
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


    // still need to figure out how to print the deduped linked list
    public void removeDuplicates() {
        Node prev = head;
        Node cur = prev.next;

        ArrayList<Integer> cache = new ArrayList<Integer>();
        cache.add(prev.data);

        while(cur != null) {
            if(cache.indexOf(cur.data) != -1) { // is duplicate
                cur = prev.next.next;
            }
            if(cur != null) {
                cache.add(cur.data);
                System.out.println("After Change: \t prev: " + prev.data + " \t cur: " + cur.data);
            }
            prev = cur;
            cur = (cur != null) ? cur.next : null;
        }
        System.out.println(cache);
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
                lower.appendToTail(cur);
            } else {
                upper.appendToTail(cur);
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


    public static Node findIntersection(Node node1, Node node2) {
        Node head1 = node1; Node cur1 = node1;
        Node head2 = node2; Node cur2 = node2;

        while(cur1 != null || cur2 != null) {

            if(cur1.next == null && cur1 != cur2) {
                System.out.println("Linked List 1 finished");
                cur1 = head2;
            }
            if(cur2.next == null && cur1 != cur2) {
                System.out.println("Linked List 2 finished");
                cur2 = head1;
            }
            if(cur1 == cur2) {
                System.out.println("Intersection Node is: " + cur1.data);
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public Node kthToLast(int k) {
        Node cur = head;
        int length = 0;

        while(cur != null) {
            length++;
            cur = cur.next;
        }

        System.out.println("Length of Linked List: " + length);
        if(k > length) {
            throw new IllegalArgumentException("K is greater than the length of the Linked List");
        }

        Node cur2 = head;
        for(int i = 0; i < length - k - 1; i++) {
            cur2 = cur2.next;
        }

        return cur2;
    }

    public Node findLoop() {
        Node slow = head;
        Node fast = head;

        while(fast!= null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }

        System.out.println(slow.data);

        return new Node(4);
    }
}
