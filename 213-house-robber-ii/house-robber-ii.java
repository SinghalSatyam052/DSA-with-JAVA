class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        Integer[] dp1 = new Integer[n]; // Rob from 0 to n-2
        Integer[] dp2 = new Integer[n]; // Rob from 1 to n-1

        return Math.max(house(nums, 0, n - 2, dp1), house(nums, 1, n - 1, dp2));
    }

    private int house(int[] nums, int start, int end, Integer[] dp) {
        if (end < start) return 0;

        if (dp[end] != null) return dp[end];

        int take = nums[end] + house(nums, start, end - 2, dp);
        int notTake = house(nums, start, end - 1, dp);

        return dp[end] = Math.max(take, notTake);
    }
}
