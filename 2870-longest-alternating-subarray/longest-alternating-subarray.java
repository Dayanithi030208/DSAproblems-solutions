class Solution {
    public int alternatingSubarray(int[] nums) {
        int n = nums.length;
        int len = 0;
        int maxlen = 0;
        for (int i = 0 ; i < n ; i++){
            int diff = 1;
            len = 1;
            for (int j = i + 1 ; j < n ; j++){
                if(nums[j] != nums[j - 1] + diff) break;
                diff *= -1;
                len++;
            }
            maxlen = Math.max(maxlen , len);
        }
        return maxlen == 1 ? -1 : maxlen;
    }
}