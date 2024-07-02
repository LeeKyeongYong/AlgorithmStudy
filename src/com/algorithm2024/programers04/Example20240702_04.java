package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int idx;
    int x;
    int y;
    TreeNode left;
    TreeNode right;

    TreeNode(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }
}

public class Example20240702_04 { //프로그래머스 2019 KAKAO BLIND RECRUITMENT  길 찾기 게임

    private static class TreeNodeComparator implements java.util.Comparator<TreeNode> {
        @Override
        public int compare(TreeNode a, TreeNode b) {
            if (a.y != b.y) {
                return Integer.compare(b.y, a.y); // Descending order by y
            }
            return Integer.compare(a.x, b.x); // Ascending order by x
        }
    }


    private static void buildBinaryTree(TreeNode root, TreeNode child) {
        if (root.x > child.x) {
            if (root.left == null) {
                root.left = child;
            } else {
                buildBinaryTree(root.left, child);
            }
        } else {
            if (root.right == null) {
                root.right = child;
            } else {
                buildBinaryTree(root.right, child);
            }
        }
    }


    private static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.idx);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }


    private static void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.idx);
    }


    public static List<List<Integer>> solution(int[][] nodeinfo) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            int idx = i + 1;
            nodes.add(new TreeNode(idx, x, y));
        }


        Collections.sort(nodes, new TreeNodeComparator());

        TreeNode root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            buildBinaryTree(root, nodes.get(i));
        }

        List<Integer> preOrderResult = new ArrayList<>();
        List<Integer> postOrderResult = new ArrayList<>();
        preOrder(root, preOrderResult);
        postOrder(root, postOrderResult);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(preOrderResult);
        answer.add(postOrderResult);

        return answer;
    }
}
