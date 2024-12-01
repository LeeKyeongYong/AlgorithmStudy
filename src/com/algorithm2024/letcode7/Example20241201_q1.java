package com.algorithm2024.letcode7;

import java.util.Arrays;

// 사용자 정의 클래스 이름 변경
class CustomTreeNode {
    int value;
    CustomTreeNode left;
    CustomTreeNode right;

    public CustomTreeNode(int value) {
        this.value = value;
    }
}

public class Example20241201_q1 {
    private CustomTreeNode root;
    private int groupCount;

    public int solution(int k, int[] num, int[][] links) {
        // 트리 생성
        TreeBuilder treeBuilder = new TreeBuilder(num, links);
        root = treeBuilder.buildTree();

        // 그룹 분할 이진 탐색
        int lo = Arrays.stream(num).max().orElse(0);
        int hi = (int) 1e9;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canDivideGroups(root, mid, k)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi + 1;
    }

    private boolean canDivideGroups(CustomTreeNode node, int limit, int maxGroups) {
        groupCount = 0;
        computeGroupSize(node, limit);
        return groupCount + 1 <= maxGroups;
    }

    private int computeGroupSize(CustomTreeNode node, int limit) {
        if (node == null) return 0;

        int leftSize = computeGroupSize(node.left, limit);
        int rightSize = computeGroupSize(node.right, limit);

        if (node.value + leftSize + rightSize <= limit) {
            return node.value + leftSize + rightSize;
        }

        if (node.value + Math.min(leftSize, rightSize) <= limit) {
            groupCount++;
            return node.value + Math.min(leftSize, rightSize);
        }

        groupCount += 2;
        return node.value;
    }
}

// 트리 빌더 클래스
class TreeBuilder {
    private final int[] values;
    private final int[][] links;

    public TreeBuilder(int[] values, int[][] links) {
        this.values = values;
        this.links = links;
    }

    public CustomTreeNode buildTree() {
        int n = values.length;
        CustomTreeNode[] nodes = new CustomTreeNode[n];
        boolean[] isChild = new boolean[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new CustomTreeNode(values[i]);
        }

        for (int i = 0; i < n; i++) {
            if (links[i][0] != -1) {
                nodes[i].left = nodes[links[i][0]];
                isChild[links[i][0]] = true;
            }
            if (links[i][1] != -1) {
                nodes[i].right = nodes[links[i][1]];
                isChild[links[i][1]] = true;
            }
        }

        // 루트 노드 찾기
        for (int i = 0; i < n; i++) {
            if (!isChild[i]) {
                return nodes[i];
            }
        }

        throw new IllegalStateException("Root node not found");
    }
}
