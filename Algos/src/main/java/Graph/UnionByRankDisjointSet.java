package Graph;

public class UnionByRankDisjointSet {
    private int[] root;
    private int[] rank;

    public UnionByRankDisjointSet(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = root[x];
        int rootY = root[y];

        if (rootX != rootY) {
            if (rank[x] > rank[y]) {
                root[rootY] = rootX;
            } else if (rank[x] < rank[y]) {
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
