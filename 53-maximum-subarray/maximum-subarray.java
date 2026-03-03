class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //          maxsum=Math.max(maxsum,sum);
        //     }
        // }
        // return maxsum;
        // int sum=0;
        // for(int i=0;i<nums.length;i++){
        //     sum+=nums[i];
        //     if(sum>maxsum){
        //         maxsum=sum;
        //     }
        //     if(sum<0){
        //         sum=0;
        //     }
        // }
        // return maxsum;
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i],
                                  currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}