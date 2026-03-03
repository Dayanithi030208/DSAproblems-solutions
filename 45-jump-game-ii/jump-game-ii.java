class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // int[][] memo = new int[n][n];
        // for (int i = 0 ; i < n ; i++){
        //     Arrays.fill(memo[i] , -1);
        // }
        // return findingMinimumJump(nums, 0 , 0 , memo);/
        int l = 0 ;
        int r = 0 ;
        int jumps = 0;
        while ( r < n - 1){
            int farthest = 0;
            for (int i = l ; i <= r ; i++){
                farthest = Math.max(farthest,i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
    // private int findingMinimumJump(int[] nums, int index,int jumps , int[][] memo){
    //     int n = nums.length;
    //     if(index >= n - 1) return jumps;
    //     if(memo[index][jumps] != -1) return memo[index][jumps];
    //     int min = Integer.MAX_VALUE;
    //     for (int i  = 1 ; i <= nums[index] ; i++){
    //         min = Math.min(min , findingMinimumJump(nums,index + i, jumps + 1,memo));
    //     }
    //     memo[index][jumps] = min;
    //     return memo[index][jumps];
    // }
}