package com.example.practice;

import javafx.util.Pair;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TreeNode {
    private int data;
    private TreeNode left, right, parent;
    private int size = 0;

    private TreeNode(int d) {
        data = d;
        size = 1;
    }

    private void insertInOrder(int d) {
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

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if(left != null) {
            left.parent = this;
        }
    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if(right != null) {
            right.parent = this;
        }
    }

    private TreeNode find(int d) {
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
    private static void listOfDepths(TreeNode node) { // method of TreeNode object
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
        ArrayList<Integer> treeOrder = new ArrayList<Integer>(); // array to keep track of Nodes to insert in order

        // recursively splitting the array by halves and inserting the "midpoint" into tree
        class HelperFunction {
            private void splitArray(int[] arr) {
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



    private static boolean isBalancedTree = true;
    private static int maxDepth(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);

        if(Math.abs(leftHeight - rightHeight) > 1) isBalancedTree = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        // System.out.println(isBalancedTree);
        return isBalancedTree;
    }


    private static boolean isValidBinaryTree = true;
    private static Double[] traverseValid(TreeNode node, String direction) {
        if (node == null)
            return new Double[] { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

        // post-order
        Double[] left = traverseValid(node.left, "left");
        Double[] right = traverseValid(node.right, "right");

        String leftData = node.left != null ? String.valueOf(node.left.data) : "null";
        String rightData = node.right != null ? String.valueOf(node.right.data) : "null";

        System.out.println("Previous Direction: " + direction + "\t Current Node: " + node.data + "\t left: " + leftData + "\t right: " + rightData);
        Double leftMax = left[0];
        Double rightMin = right[1];
        System.out.println("Before transformation: \t data: " + node.data + "\t leftMax: " + leftMax + "\t rightMin: " + rightMin);

        if((double) node.data < leftMax || (double) node.data > rightMin) {
            System.out.println("Tree is not valid");
            isValidBinaryTree = false;
        }

        if(direction.equals("right"))
            rightMin = Math.min((double) node.data, rightMin);
        else
            leftMax = Math.max((double) node.data, leftMax);

        System.out.println("After transformation: \t data: " + node.data + "\t leftMax: " + leftMax + "\t rightMin: " + rightMin);
        System.out.println();

        // PROBLEM HERE (I THINK)
        return new Double[] {leftMax, rightMin};
    };

    private static boolean validate(TreeNode node) {
        traverseValid(node, "");
//        if(node.left != null) {
//            TreeNode left = node.left;
//            traverseValid(left, "left");
//        }
//        if(node.right != null) {
//            TreeNode right = node.right;
//            traverseValid(right, "right");
//        }
        System.out.println(isValidBinaryTree);
        return isValidBinaryTree;
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
        System.out.println();
        System.out.println("Minimum Height Tree:");
        System.out.println(Arrays.toString(nodeArr));
        TreeNode smallTree = createMinHeightTree(nodeArr);
        listOfDepths(smallTree);

        TreeNode root2 = new TreeNode(10);
        root2.insertInOrder(5);
        root2.insertInOrder(15);
        root2.insertInOrder(2);
        root2.insertInOrder(7);
        root2.insertInOrder(6);
        root2.insertInOrder(1);
        root2.insertInOrder(3);
        root2.insertInOrder(4);
        root2.insertInOrder(13);
        root2.insertInOrder(17);
        root2.insertInOrder(16);
        root2.insertInOrder(30);
        listOfDepths(root2);
        validate(root2);
    }

}
