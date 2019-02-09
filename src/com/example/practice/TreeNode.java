package com.example.practice;

import jdk.nashorn.api.tree.Tree;

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

}
