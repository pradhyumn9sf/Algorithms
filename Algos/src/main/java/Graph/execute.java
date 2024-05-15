package Graph;

public class execute {
    public static void main(String[] args) {
        QuickFindDisjointSet quickFindDisjointSet = new QuickFindDisjointSet(10);
        quickFindDisjointSet.union(1, 2);
        quickFindDisjointSet.union(2, 5);
        quickFindDisjointSet.union(5, 6);
        quickFindDisjointSet.union(6, 7);
        quickFindDisjointSet.union(3, 8);
        quickFindDisjointSet.union(8, 9);

        System.out.println(quickFindDisjointSet.connected(1, 5)); // true
        System.out.println(quickFindDisjointSet.connected(5, 7)); // true
        System.out.println(quickFindDisjointSet.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        quickFindDisjointSet.union(9, 4);
        System.out.println(quickFindDisjointSet.connected(4, 9)); // true

        QuickUnionDisjointSet quickUnionDisjointSet = new QuickUnionDisjointSet(10);
        quickUnionDisjointSet.union(1, 2);
        quickUnionDisjointSet.union(2, 5);
        quickUnionDisjointSet.union(5, 6);
        quickUnionDisjointSet.union(6, 7);
        quickUnionDisjointSet.union(3, 8);
        quickUnionDisjointSet.union(8, 9);

        System.out.println(quickUnionDisjointSet.connected(1, 5)); // true
        System.out.println(quickUnionDisjointSet.connected(5, 7)); // true
        System.out.println(quickUnionDisjointSet.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        quickUnionDisjointSet.union(9, 4);
        System.out.println(quickUnionDisjointSet.connected(4, 9));


        UnionByRankDisjointSet unionByRankDisjointSet = new UnionByRankDisjointSet(10);
        unionByRankDisjointSet.union(1, 2);
        unionByRankDisjointSet.union(2, 5);
        unionByRankDisjointSet.union(5, 6);
        unionByRankDisjointSet.union(6, 7);
        unionByRankDisjointSet.union(3, 8);
        unionByRankDisjointSet.union(8, 9);

        System.out.println(unionByRankDisjointSet.connected(1, 5)); // true
        System.out.println(unionByRankDisjointSet.connected(5, 7)); // true
        System.out.println(unionByRankDisjointSet.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        unionByRankDisjointSet.union(9, 4);
        System.out.println(unionByRankDisjointSet.connected(4, 9));
    }
}
