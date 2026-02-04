class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int max = 0;
        int n = nums.length;
        int flips = 0;
        for (int right = 0;right < n;right++){
            while (flips == k && nums[right] == 0){
                if(nums[left] == 0) flips--;
                count--;
                left++;
            }
            if (nums[right] == 0) flips++;
            count++;
            max = Math.max(max,count);
        }
        return max;
    }
}