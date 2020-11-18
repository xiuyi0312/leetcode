package com.op.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LayerTraverseSolution {

    public static void main(String[] args) {
//                3
//            9		20
//        8		15		7
//    4       2		6		11
        TreeNode root = new TreeNode(3);
        TreeNode newNode = new TreeNode(9);
        root.left = newNode;
        newNode = new TreeNode(20);
        root.right = newNode;

        newNode = new TreeNode(8);
        root.left.left = newNode;
        newNode = new TreeNode(15);
        root.left.right = newNode;
        newNode = new TreeNode(7);
        root.right.right = newNode;
        newNode = new TreeNode(4);
        root.left.left.left = newNode;
        newNode = new TreeNode(2);
        root.left.left.right = newNode;

        LayerTraverseSolution solution = new LayerTraverseSolution();
//        System.out.println(solution.levelOrder(root));
        System.out.println(solution.zigzagLevelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(null);
        List<Integer> currentLevel = new ArrayList<>();
        while (!list.isEmpty()) {
            TreeNode remove = list.remove(0);
            if (remove == null) {
//                System.out.println("\n");
                if (!list.isEmpty()) {
                    list.add(null);
                }
                result.add(currentLevel);
                currentLevel = new ArrayList<>();
            } else {
//                System.out.println(remove.val);
                currentLevel.add(remove.val);
                if (remove.left != null) {
                    list.add(remove.left);
                }
                if (remove.right != null) {
                    list.add(remove.right);
                }
            }
        }
        if (!currentLevel.isEmpty()) {
            result.add(currentLevel);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(null);
        List<Integer> currentLevel = new ArrayList<>();
        boolean flag = true;
        while (!list.isEmpty()) {
            TreeNode remove = list.remove(0);
            if (remove == null) {
//                System.out.println("\n");
                if (!list.isEmpty()) {
                    list.add(null);
                }
                flag = !flag;
                result.add(currentLevel);
                currentLevel = new ArrayList<>();
            } else {
//                System.out.println(remove.val);
                if(flag) {
                    currentLevel.add(remove.val);
                } else {
                    currentLevel.add(0, remove.val);
                }
                if (remove.left != null) {
                    list.add(remove.left);
                }
                if (remove.right != null) {
                    list.add(remove.right);
                }
            }
        }
        if (!currentLevel.isEmpty()) {
            result.add(currentLevel);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
