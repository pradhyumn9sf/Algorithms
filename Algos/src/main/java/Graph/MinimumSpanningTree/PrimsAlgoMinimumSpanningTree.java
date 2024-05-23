package Graph.MinimumSpanningTree;

import java.util.Map;
import java.util.PriorityQueue;

public class PrimsAlgoMinimumSpanningTree {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        for (int i = 1; i < size; i++) {
            int cost = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][0]);
            Edge e = new Edge(0, i, cost);
            priorityQueue.add(e);
        }
        int result = 0;
        int count = size - 1;
        boolean[] visited = new boolean[size];
        visited[0] = true;
        while (!priorityQueue.isEmpty() && count > 0) {
            Edge e = priorityQueue.poll();
            int point1 = e.point1;
            int point2 = e.point2;
            if (!visited[point2]) {
                result += e.cost;
                for (int i = 0; i < size; i++) {
                    if (!visited[i] && i != point2) {
                        int cost = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][0]);
                        Edge e1 = new Edge(0, i, cost);
                        priorityQueue.add(e1);
                    }
                }
                count --;
            }
        }


        return  result;
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

}
