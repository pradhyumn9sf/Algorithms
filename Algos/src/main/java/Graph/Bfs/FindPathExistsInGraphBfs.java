package Graph.Bfs;

import java.util.*;

public class FindPathExistsInGraphBfs {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);
        seen[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                return true;
            }

            for (Integer adj : adjList.get(current)) {
                if (!seen[adj]) {
                    seen[adj] = true;
                    queue.add(adj);
                }
            }
        }
        return false;

    }
}
