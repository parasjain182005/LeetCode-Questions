class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            int s1 = digitSum(nums[a]);
            int s2 = digitSum(nums[b]);

            if (s1 != s2) {
                return s1 - s2;
            }
            return nums[a] - nums[b];
        });

        boolean[] vis = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || indices[i] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!vis[j]) {
                vis[j] = true;
                j = indices[j];
                cycleSize++;
            }
            swaps += cycleSize - 1;
        }
        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}