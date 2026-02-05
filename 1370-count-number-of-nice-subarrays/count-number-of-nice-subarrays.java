class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return findSubArrayWithSum(nums,k) - findSubArrayWithSum(nums,k-1);
    }
    private int findSubArrayWithSum(int[] nums,int goal){
        if(goal == -1) return 0;
        int left = 0;
        int sum = 0;
        int n = nums.length;
        int len = 0;
        for (int right = 0; right < n; right++){
            sum += nums[right] % 2;
            while(left <= right && sum > goal){
                sum -= nums[left] % 2;
                left++;
            }
            len += ((right - left) + 1);
        }
        return len;
    }
}