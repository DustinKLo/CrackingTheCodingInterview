package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BaseTreeNode {
    private int data;
    private BaseTreeNode left, right;
    private int size = 0;

    private BaseTreeNode(int d) {
        data = d;
        size = 1;
    }

    private void insertLeft(BaseTreeNode n) {
        this.left = n;
    }
    private void insertRight(BaseTreeNode n) {
        this.right = n;
    }

    private boolean isValidTree = true;
    private ArrayList<ArrayList<Integer>> traverseValidate(BaseTreeNode root, String direction) {
        if (root == null) {
             ArrayList<Integer> leftValues = new ArrayList<Integer>();
             ArrayList<Integer> rightValues = new ArrayList<Integer>();
             ArrayList<ArrayList<Integer>> arraySet = new ArrayList<ArrayList<Integer>>();
             arraySet.add(leftValues);
             arraySet.add(rightValues);
             return arraySet;
        }
        ArrayList<ArrayList<Integer>> leftArrays = traverseValidate(root.left, "left");
        ArrayList<ArrayList<Integer>> rightArrays = traverseValidate(root.right, "right");

        ArrayList<Integer> leftSideValues = leftArrays.get(0);
        leftSideValues.addAll(leftArrays.get(1)); // combining the arrays in the left side into 1 array

        ArrayList<Integer> rightSideValues = rightArrays.get(0);
        rightSideValues.addAll(rightArrays.get(1)); // combining teh arrays in the right side into 1 array

        double maxLeftSide = leftSideValues.size() > 0 ? Collections.max(leftSideValues) : Double.NEGATIVE_INFINITY;
        double minRightSide = rightSideValues.size() > 0 ? Collections.min(rightSideValues) : Double.POSITIVE_INFINITY;

        System.out.println(root.data);
        System.out.println("Left Array: " + leftSideValues.toString());
        System.out.println("Right Array: " + rightSideValues.toString());

        if (root.data > minRightSide || root.data < maxLeftSide) {
            System.out.println("Not a valid tree");
            isValidTree = false;
        } else {
            System.out.println("IS a valid tree");
        }
        System.out.println();

        switch (direction) {
            case "right":
                rightSideValues.add(root.data);
                break;
            case "left":
                leftSideValues.add(root.data);
                break;
            default:
                break;
        }

        ArrayList<ArrayList<Integer>> arraySet = new ArrayList<ArrayList<Integer>>();
        arraySet.add(leftSideValues);
        arraySet.add(rightSideValues);

        return arraySet;
    }
    private boolean validate() {
        traverseValidate(this, "");
        System.out.println(isValidTree);
        return isValidTree;
    }

    public static void main(String[] args) {
        BaseTreeNode a1 = new BaseTreeNode(20);
        a1.left = new BaseTreeNode(10);
        a1.left.left = new BaseTreeNode(5);
        a1.left.right = new BaseTreeNode(15);
        a1.left.right.left = new BaseTreeNode(12);
        a1.left.right.right = new BaseTreeNode(16);
        a1.left.left.left = new BaseTreeNode(1);
        a1.left.left.right = new BaseTreeNode(6);
        a1.right = new BaseTreeNode(30);
        a1.right.left = new BaseTreeNode(25);
        a1.right.left.left = new BaseTreeNode(5);
        a1.right.right = new BaseTreeNode(35);
        a1.right.right.left = new BaseTreeNode(10);

        a1.validate();
    }

}
