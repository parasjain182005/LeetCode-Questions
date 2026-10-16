
class Solution {
    static final long MOD = 1000000007L;
    long[] sum, sq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            update(1, 0, n - 1, last[nums[i]] + 1, i);
            ans = (ans + sq[1]) % MOD;
            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void apply(int p, int l, int r, long v) {
        long len = r - l + 1L;

        sq[p] = (sq[p] + 2 * v * sum[p]
                + v * v % MOD * len) % MOD;
        sum[p] = (sum[p] + v * len) % MOD;
        lazy[p] = (lazy[p] + v) % MOD;
    }

    void push(int p, int l, int r) {
        if (lazy[p] == 0 || l == r) return;

        int m = (l + r) / 2;
        apply(2 * p, l, m, lazy[p]);
        apply(2 * p + 1, m + 1, r, lazy[p]);
        lazy[p] = 0;
    }

    void update(int p, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return;

        if (ql <= l && r <= qr) {
            apply(p, l, r, 1);
            return;
        }

        push(p, l, r);
        int m = (l + r) / 2;

        update(2 * p, l, m, ql, qr);
        update(2 * p + 1, m + 1, r, ql, qr);

        sum[p] = (sum[2 * p] + sum[2 * p + 1]) % MOD;
        sq[p] = (sq[2 * p] + sq[2 * p + 1]) % MOD;
    }
}
