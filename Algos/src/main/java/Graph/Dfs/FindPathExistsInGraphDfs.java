package Graph.Dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPathExistsInGraphDfs {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<Integer>();
        boolean[] seen = new boolean[n];
        stack.push(start);

        while (!stack.empty()) {
            int node = stack.pop();
            if (node == end) {
                return true;
            }

            if (seen[node]) {
                continue;
            }
            seen[node] = true;

            for (int adjacent : adjacencyList.get(node)) {
                stack.push(adjacent);
            }
        }
        return false;
    }
}
