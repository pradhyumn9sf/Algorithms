package Graph.Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceTargetBfs {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int n = graph.length;
        Queue<List<Integer>> queue = new LinkedList<>();
        path.add(0);
        queue.add(path);
        while (!queue.isEmpty()) {
            List<Integer> tmpPath = queue.poll();
            int current = tmpPath.get(tmpPath.size() - 1);
            for (int adj : graph[current]) {
                tmpPath.add(adj);
                if (adj == graph.length - 1) {
                    paths.add(tmpPath);
                } else {
                    queue.add(tmpPath);
                }
            }
        }
        return paths;
    }
}
