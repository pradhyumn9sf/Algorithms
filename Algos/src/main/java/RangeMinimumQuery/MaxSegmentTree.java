package RangeMinimumQuery;

public class MaxSegmentTree {
    int[] arr = new int[10000];
    int[] segTree = new int[4 * 10000];
    void build(int ind, int low, int high) {
        if (low == high) {
            segTree[ind] = arr[low];
            return ;


        }
        int mid = low + (high - low) / 2;
        build(2 * ind + 1, low, mid);
        build(2 * ind + 2, mid + 1, high);
        segTree[ind] = Math.max(segTree[2 * ind + 1], segTree[2 * ind + 2]);

    }
    int query(int ind, int low, int high, int l, int r) {
//        fully overlap
        if (low >= l && high <= r) {
            return segTree[ind];
        }
//        no overlap
        if (low > r || high < l) {
            return Integer.MIN_VALUE;
        }
//        partial overlap go in both direction
        int mid = l + (r - l) / 2;
        int left = query(2 * ind + 1, low, high, l, mid);
        int right = query(2 * ind + 2, low, high, mid + 1, r);
        return Math.max(left, right);

    }
    public static void main(String[] args) {

    }
}
