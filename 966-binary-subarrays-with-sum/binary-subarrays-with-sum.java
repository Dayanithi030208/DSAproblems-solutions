class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int prefixsum = 0;
        // map.put(0,1);
        // int count = 0;
        // int n = nums.length;
        // for (int i = 0; i < n; i++){
        //     prefixsum += nums[i];
        //     if(map.containsKey(prefixsum - goal)){
        //         count += map.get(prefixsum - goal);
        //     }
        //     map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        // }
        // return count;
        return findSubArrayWithSum(nums,goal) - findSubArrayWithSum(nums,goal-1);
    }
    private int findSubArrayWithSum(int[] nums,int goal){
        if(goal == -1) return 0;
        int left = 0;
        int sum = 0;
        int n = nums.length;
        int len = 0;
        for (int right = 0; right < n; right++){
            sum += nums[right];
            while(left <= right && sum > goal){
                sum -= nums[left];
                left++;
            }
            len += ((right - left) + 1);
        }
        return len;
    }
}