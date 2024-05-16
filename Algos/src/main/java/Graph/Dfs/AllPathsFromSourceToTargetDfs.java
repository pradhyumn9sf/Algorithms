package Graph.Dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTargetDfs {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }
        for (int i = 0; i < graph.length; i++) {
            paths.add(new ArrayList<>());
        }
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, path, paths);
        return paths;

    }

    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(path);
            return ;
        }
        int[] nextNodes = graph[node];
        for (int nextNode : nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }

}
