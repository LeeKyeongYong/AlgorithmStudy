package com.algorithm2024.programers07;

import java.util.Arrays;

public class Example20241203_Q1 {
    private TreeNode root;
    private int[] people;

    public int Example20241203_Q1(int k, int[] num, int[][] links) {
        people = num;

        // 트리 빌더를 통해 트리 생성
        TreeBuilder treeBuilder = new TreeBuilder(num, links);
        root = treeBuilder.build();

        // 이진 탐색으로 그룹의 최소 값을 계산
        int lo = Arrays.stream(num).max().orElse(0); // 최소 값은 가장 큰 사람 수
        int hi = (int) 1e9; // 최대 값은 임의의 큰 값

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            GroupCalculator calculator = new GroupCalculator(mid);
            int groupCount = calculator.calculateGroups(root);

            if (groupCount <= k) {
                hi = mid - 1; // 그룹 수를 만족하면 더 작은 값을 찾는다.
            } else {
                lo = mid + 1; // 그룹 수를 초과하면 더 큰 값을 찾는다.
            }
        }

        return lo; // 최적의 최소 값 반환
    }
}

// 트리 노드 클래스 (Composite 패턴)
class TreeNode {
    int id; // 노드 ID
    int peopleCount; // 현재 노드의 사람 수
    TreeNode left; // 왼쪽 자식 노드
    TreeNode right; // 오른쪽 자식 노드

    public TreeNode(int id, int peopleCount) {
        this.id = id;
        this.peopleCount = peopleCount;
    }
}
// 트리 빌더 클래스 (Builder 패턴)
class TreeBuilder {
    private final int[] people;
    private final int[][] links;
    private final TreeNode[] nodes;
    private final int[] parent;

    public TreeBuilder(int[] people, int[][] links) {
        this.people = people;
        this.links = links;
        this.nodes = new TreeNode[people.length];
        this.parent = new int[people.length];
        Arrays.fill(parent, -1);
    }

    public TreeNode build() {
        for (int i = 0; i < people.length; i++) {
            nodes[i] = new TreeNode(i, people[i]);
        }

        for (int i = 0; i < links.length; i++) {
            int left = links[i][0];
            int right = links[i][1];

            if (left != -1) {
                nodes[i].left = nodes[left];
                parent[left] = i;
            }
            if (right != -1) {
                nodes[i].right = nodes[right];
                parent[right] = i;
            }
        }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                return nodes[i]; // 루트 노드 반환
            }
        }

        throw new IllegalStateException("Root node not found");
    }
}

// 그룹 계산기 클래스
class GroupCalculator {
    private final int limit; // 그룹 제한 값
    private int groupCount; // 그룹 수

    public GroupCalculator(int limit) {
        this.limit = limit;
        this.groupCount = 0;
    }

    public int calculateGroups(TreeNode root) {
        dfs(root);
        return groupCount + 1; // 그룹 수 반환 (현재 노드 포함)
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // null 노드는 0명으로 간주
        }

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        // 현재 노드와 자식들의 합이 limit 이하인지 확인
        if (node.peopleCount + leftSum + rightSum <= limit) {
            return node.peopleCount + leftSum + rightSum;
        }

        // 두 그룹으로 나눠야 하는 경우
        if (node.peopleCount + Math.min(leftSum, rightSum) <= limit) {
            groupCount++;
            return node.peopleCount + Math.min(leftSum, rightSum);
        }

        // 추가로 두 그룹이 필요
        groupCount += 2;
        return node.peopleCount;
    }
}