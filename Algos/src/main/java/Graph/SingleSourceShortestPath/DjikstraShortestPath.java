package Graph.SingleSourceShortestPath;

public class DjikstraShortestPath {
    int minDistance(int[] dist, boolean[] visited) {
        int minVal = Integer.MAX_VALUE, minIndex = -1;
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && dist[i] <= minVal) {
                minVal = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    void printSolution(int dist[]) {
        int n = dist.length;
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public void djikstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j]) {
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }
        printSolution(dist);
    }
    public static void main(String[] args) {
        int graph[][]
                = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };


        DjikstraShortestPath djikstraShortestPath = new DjikstraShortestPath();
        djikstraShortestPath.djikstra(graph, 0);
    }
}
