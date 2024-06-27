class Solution {
    constructor() {
        this.answer = 0;
        this.graph = [];
        this.memo = new Map();
    }

    solution = (info, edges) => {
        this.initializeGraph(info.length);
        this.buildGraph(edges);
        this.dfs(info, new Set([0]), 0, 0, 0);
        return this.answer;
    }

    initializeGraph = (size) => {
        this.graph = Array.from({ length: size }, () => []);
    }

    buildGraph = (edges) => {
        edges.forEach(([from, to]) => this.graph[from].push(to));
    }

    dfs = (info, nextNodes, node, sheep, wolf) => {
        const newSheep = sheep + (info[node] === 0);
        const newWolf = wolf + (info[node] === 1);

        if (newSheep <= newWolf) return;

        this.answer = Math.max(this.answer, newSheep);

        const key = `${[...nextNodes].sort().join(',')},${node},${newSheep},${newWolf}`;
        if (this.memo.has(key)) return;
        this.memo.set(key, true);

        nextNodes.delete(node);
        this.graph[node].forEach(nextNode => nextNodes.add(nextNode));

        nextNodes.forEach(nextNode => {
            this.dfs(info, new Set(nextNodes), nextNode, newSheep, newWolf);
        });
    }
}

// 사용 예시
const sol = new Solution();
const info = [0, 0, 1, 1, 1, 0, 1, 0, 1, 0];
const edges = [[0, 1], [1, 2], [1, 3], [2, 4], [3, 5], [3, 6], [4, 7], [4, 8], [5, 9]];
console.log(sol.solution(info, edges));  // 예상 결과: 최대 양의 수