class Solution {
    public int rob(int[] nums) {
        // int[] memo=new int[nums.length];
        // Arrays.fill(memo,-1);
        // return findMaxNonAdjacentSum(nums,memo,nums.length-1);
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        memo[0] = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += memo[i - 2];
            }
            int notpick = memo[i - 1];
            memo[i] = Math.max(pick, notpick);
        }
        return memo[n - 1];
    }

    public int findMaxNonAdjacentSum(int[] nums, int[] memo, int index) {
        if (index == 0)
            return nums[index];
        if (index < 0)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        int pick = nums[index] + findMaxNonAdjacentSum(nums, memo, index - 2);
        int notpick = findMaxNonAdjacentSum(nums, memo, index - 1);
        memo[index] = Math.max(pick, notpick);
        return memo[index];
    }
}