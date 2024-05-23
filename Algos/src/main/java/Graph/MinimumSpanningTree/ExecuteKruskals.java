package Graph.MinimumSpanningTree;

public class ExecuteKruskals {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        KruskalsAlgoMinCostToConnectAllPoints kruskalsAlgoMinCostToConnectAllPoints = new KruskalsAlgoMinCostToConnectAllPoints();
        System.out.print("Minimum Cost to Connect Points = ");
        System.out.println(kruskalsAlgoMinCostToConnectAllPoints.minCostConnectPoints(points));
    }
}
