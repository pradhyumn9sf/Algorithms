package Graph.MinimumSpanningTree;

import java.util.PriorityQueue;

public class KruskalsAlgoMinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < size; i++) {
            int[] coordinates1 = points[i];
            for (int j = i + 1; j < size; j++) {
                int[] coordinates2 = points[j];
                int cost = Math.abs(coordinates1[0] - coordinates2[0]) + Math.abs(coordinates1[1] - coordinates2[1]);
                Edge e = new Edge(i, j, cost);
                priorityQueue.add(e);
            }
        }
        int result = 0;
        int count = size - 1;
        while (!priorityQueue.isEmpty() && count > 0) {
            Edge e = priorityQueue.poll();
            if (!uf.connected(e.point1, e.point2)) {
                uf.union(e.point1, e.point2);
                count --;
                result += e.cost;
            }
        }
        return result;

    }
    class Edge {
        int point1;
        int point2;
        int cost;

        Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }
    }

    class UnionFind {
        private
            int[] root;
            int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

}
