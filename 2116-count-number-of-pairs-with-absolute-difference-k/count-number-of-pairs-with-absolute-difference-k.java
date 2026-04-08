class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            int value = nums[i];
            for (int j = i + 1 ; j < n ; j++){
                if( j == i) continue;
                if(Math.abs(value - nums[j]) == k) count++;
            }
        }
        return count;
    }
}