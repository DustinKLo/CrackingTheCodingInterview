package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

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
    //    other queue as the "next" layer that we en-queue (non-null nodes) every when we go through the current layer
    //    make the old queue the new queue and set the new queue to empty
    public static void listOfDepths(TreeNode node) { // method of TreeNode object
        // ArrayList of LinkedLists to keep track of nodes at each depth

        // Given the structure of the TreeNode class
        // We can append to the ArrayList the order of which we insert the nodes into the Tree
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


    public static TreeNode createMinHeightTree(int[] arr) {
        // try recursively splitting the array by halves and inserting the "midpoint" into tree
        ArrayList<Integer> treeOrder = new ArrayList<Integer>();

        class HelperFunction {
            public void splitArray(int[] arr) {
                // get mid point of array every time we split it in half
                if(arr.length == 1) { // add only element to TreeNode
                    treeOrder.add(arr[0]);
                } else if(arr.length == 2) { // add both elements to TreeNode
                    treeOrder.add(arr[0]);
                    treeOrder.add(arr[1]);
                } else {
                    int mid = arr.length / 2; // find and add midpoint to TreeNode
                    // separate the left and right sides from midpoint and recurse
                    int[] left = Arrays.copyOfRange(arr, 0, mid);
                    int[] right = Arrays.copyOfRange(arr, mid + 1, arr.length);
                    treeOrder.add(arr[mid]);
                    splitArray(left);
                    splitArray(right);
                }
            }
        }
        HelperFunction helper = new HelperFunction();
        helper.splitArray(arr);
        System.out.println(treeOrder.toString());

        TreeNode minTree = new TreeNode(treeOrder.get(0));
        for(int i = 1; i < treeOrder.size(); i++) {
            minTree.insertInOrder(treeOrder.get(i));
        }

        return minTree;
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

        int[] nodeArr = IntStream.range(1, 102).toArray();
        TreeNode smallTree = createMinHeightTree(nodeArr);
        listOfDepths(smallTree);
    }

}
