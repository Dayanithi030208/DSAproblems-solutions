class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxcurrentsum = 0;
        int mincurrentsum = 0;
        int maxsum = nums[0];
        int minsum = nums[0];
        int totalsum = 0;
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            totalsum += nums[i];

            maxcurrentsum = Math.max(nums[i] , maxcurrentsum + nums[i]);
            maxsum = Math.max(maxsum , maxcurrentsum);

            mincurrentsum = Math.min(nums[i] , mincurrentsum + nums[i]);
            minsum = Math.min(minsum , mincurrentsum);
        }
        if ( maxsum < 0) return maxsum;
        return Math.max(maxsum , totalsum - minsum);
    }
}