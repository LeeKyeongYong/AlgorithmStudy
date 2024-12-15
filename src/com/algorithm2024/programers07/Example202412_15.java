package com.algorithm2024.programers07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Example202412_15 {

    public static int[] Example202412_15(int[][] edges, int[] target) {
        int n = target.length + 1;
        Tree tree = new Tree(n);

        for (int[] edge : edges) {
            tree.addEdge(edge[0], edge[1]);
        }

        boolean continueDistribution = true;
        List<Integer> visitOrder = new ArrayList<>();
        while (continueDistribution) {
            int leafNode = tree.dfs(1);
            visitOrder.add(leafNode);

            Node node = tree.getNode(leafNode);
            if (target[leafNode - 1] < node.numberOfCards) {
                return new int[]{-1}; // 실패 시 바로 반환
            }

            continueDistribution = false;
            for (int i = 1; i < n; i++) {
                if (target[i - 1] > tree.getNode(i).numberOfCards * 3) {
                    continueDistribution = true;
                }
            }
        }

        // 카드 배분
        CardDistributor distributor = new CardDistributor(new DefaultCardDistributionStrategy());
        distributor.assignCards(tree, target);

        // 결과 생성
        int[] result = new int[visitOrder.size()];
        int idx = 0;
        for (int nodeIdx : visitOrder) {
            Node node = tree.getNode(nodeIdx);
            result[idx++] = node.cardSequence.poll();
        }

        return result;
    }

}
class Node {
    int numberOfCards = 0;
    Queue<Integer> children = new LinkedList<>();
    Queue<Integer> cardSequence = new LinkedList<>();

    void addChild(int child) {
        children.offer(child);
    }

    int getNextChild() {
        int next = children.poll();
        children.offer(next);
        return next;
    }
}

class Tree {
    private final List<Node> nodes;

    public Tree(int size) {
        nodes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nodes.add(new Node());
        }
    }

    public void addEdge(int parent, int child) {
        nodes.get(parent).addChild(child);
    }

    public int dfs(int currentNode) {
        Node node = nodes.get(currentNode);
        if (node.children.isEmpty()) {
            node.numberOfCards++;
            return currentNode;
        }

        int nextChild = node.getNextChild();
        return dfs(nextChild);
    }

    public Node getNode(int index) {
        return nodes.get(index);
    }

    public List<Node> getNodes() {
        return nodes;
    }
}

interface CardDistributionStrategy {
    Queue<Integer> distributeCards(int target, int numberOfCards);
}

class DefaultCardDistributionStrategy implements CardDistributionStrategy {
    @Override
    public Queue<Integer> distributeCards(int target, int numberOfCards) {
        Queue<Integer> sequence = new LinkedList<>();
        while (numberOfCards-- > 0) {
            for (int card : new int[]{1, 2, 3}) {
                if (target - card > numberOfCards * 3 || target - card < numberOfCards) continue;
                sequence.offer(card);
                target -= card;
                break;
            }
        }
        return sequence;
    }
}

class CardDistributor {
    private final CardDistributionStrategy strategy;

    public CardDistributor(CardDistributionStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignCards(Tree tree, int[] target) {
        for (int i = 1; i < target.length + 1; i++) {
            Node node = tree.getNode(i);
            node.cardSequence = strategy.distributeCards(target[i - 1], node.numberOfCards);
        }
    }
}
