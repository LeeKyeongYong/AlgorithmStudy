class Solution {
    constructor() {
        this.answer = 0;
        this.graph = [];
    }

    solution(info, edges) {
        this.initializeGraph(info.length);
        this.buildGraph(edges);

        this.dfs(info, [0], 0, 0, 0);

        return this.answer;
    }

    initializeGraph(size) {
        for (let i = 0; i < size; i++) {
            this.graph.push([]);
        }
    }

    buildGraph(edges) {
        edges.forEach(edge => {
            this.graph[edge[0]].push(edge[1]);
        });
    }

    dfs(info, nextNodes, node, sheep, wolf) {
        const newSheep = sheep + (info[node] === 0 ? 1 : 0);
        const newWolf = wolf + (info[node] === 1 ? 1 : 0);

        if (newSheep <= newWolf) {
            return;
        }

        this.answer = Math.max(this.answer, newSheep);

        const newNextNodes = [...nextNodes];
        newNextNodes.push(...this.graph[node]);
        const nodeIndex = newNextNodes.indexOf(node);
        if (nodeIndex !== -1) {
            newNextNodes.splice(nodeIndex, 1);
        }

        newNextNodes.forEach(nextNode => {
            this.dfs(info, newNextNodes, nextNode, newSheep, newWolf);
        });
    }
}

// 사용 예시
const sol = new Solution();
const info = [0, 0, 1, 1, 1, 0, 1, 0, 1, 0];
const edges = [[0, 1], [1, 2], [1, 3], [2, 4], [3, 5], [3, 6], [4, 7], [4, 8], [5, 9]];
console.log(sol.solution(info, edges));  // 예상 결과: 최대 양의 수
