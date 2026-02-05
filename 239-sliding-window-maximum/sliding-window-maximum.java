class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int anslength=nums.length-k+1;
        // int[] ans=new int[anslength];
        // int index=0;
        // for(int i=0;i<=nums.length-k;i++){
        //     int max=Integer.MIN_VALUE;
        //     for(int j=i;j<i+k;j++){
        //         if(nums[j]>max) max=nums[j];
        //     }
        //     ans[index++]=max;
        // }
        // return ans;
        int n = nums.length;
        int[] maxWindowArray = new int[n - k + 1];
        Deque<Integer> windowDq = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if(!windowDq.isEmpty() && windowDq.peekFirst() <= i-k){
                windowDq.pollFirst();
            }
            while(!windowDq.isEmpty() && nums[windowDq.peekLast()] <= nums[i]){
                windowDq.pollLast();
            }
            windowDq.offerLast(i);
            if (i >= k-1){
                maxWindowArray[i - k + 1] = nums[windowDq.peekFirst()];
            }
        }
        return maxWindowArray;
    }
}