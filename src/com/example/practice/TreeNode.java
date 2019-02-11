package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public void insertInOrder(int d) {
        if(d <= data) { // traverse down the left side of tree
            if(left == null) {
                setLeftChild(new TreeNode(d)); // adds node to tree (BASE CASE)
            } else {
                left.insertInOrder(d); // recurse if node is not empty
            }
        } else { // traverse down right side of tree
            if(right == null) {
                setRightChild(new TreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public void setLeftChild(TreeNode left) {
        this.left = left;
        if(left != null) {
            left.parent = this;
        }
    }

    public void setRightChild(TreeNode right) {
        this.right = right;
        if(right != null) {
            right.parent = this;
        }
    }

    public TreeNode find(int d) {
        if(d == data) {// base case
            return this;
        } else if(d <= data) { // traverse to the left of the TreeNode
            return left != null ? left.find(d) : null;
        } else if(d > data) { // traverse to the right of the TreeNode
            return right != null ? right.find(d) : null;
        }
        return null; // if TreeNode is not found
    }


    // ****************************************************************************************** //
    // PRACTICE PROBLEMS

    // this is a depth first search solution (recursion)
    // breadth first search algorithm requires 2 queues
    //    one queue as the current "layer" that we dequeue
    //    one queue as the "next" layer that we en-queue (non-null nodes) every when we go through the current layer
    //    make the old queue the new queue and set the new queue to empty
    public static void listOfDepths(TreeNode node) { // method of TreeNode object
        // ArrayList of LinkedLists to keep track of nodes at each depth
        ArrayList<LinkedList> depthList = new ArrayList<LinkedList>();

        class HelperFunction { // helper function to traverse through the tree and add onto the array
            private void traverseTree(TreeNode node, int depth) {
                if(node != null) {
                    Node n = new Node(node.data);
                    if(depthList.size() - 1 < depth) { // if the array value does not exist
                        LinkedList linkedList = new LinkedList();
                        linkedList.appendToTail(n);
                        depthList.add(linkedList);
                    } else { // if the array value already exists
                        LinkedList linkedList = depthList.get(depth);
                        linkedList.appendToTail(n);
                        depthList.set(depth, linkedList);
                    }

                    traverseTree(node.left, depth + 1);
                    traverseTree(node.right, depth + 1);
                }
            }
        }

        // calls helper function to populate the array with Linked List for each depth
        HelperFunction helper = new HelperFunction();
        helper.traverseTree(node, 0);

        // depthList.forEach(linkedList -> linkedList.printLinkedList()); // print each linked list
        for(int i = 0; i < depthList.size(); i++) {
            System.out.println("Layer " + (i + 1) + ": ");
            depthList.get(i).printLinkedList();
            System.out.println();
        }
    }


    public static TreeNode minHeightTree(Integer[] arr) {
        // try recursively splitting the array by halves and inserting the "midpoint" into tree
        class HelperFunction {
            public void splitArray(Integer[] subArr, int left, int right) {

            }
        }
        // Integer[] x = Arrays.copyOfRange(arr, 0, 5);
        HelperFunction helper = new HelperFunction();
        return new TreeNode(1);
    }


    // ****************************************************************************************** //
    // MAIN METHOD
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);

        root.insertInOrder(10);
        root.insertInOrder(30);

        root.insertInOrder(5);
        root.insertInOrder(15);
        root.insertInOrder(25);
        root.insertInOrder(35);

        root.insertInOrder(2);
        root.insertInOrder(7);
        root.insertInOrder(12);
        root.insertInOrder(17);
        root.insertInOrder(22);
        root.insertInOrder(27);
        root.insertInOrder(32);
        root.insertInOrder(37);
        listOfDepths(root);


        Integer[] nodeArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(Arrays.toString(nodeArr));
        minHeightTree(nodeArr);
    }

}
