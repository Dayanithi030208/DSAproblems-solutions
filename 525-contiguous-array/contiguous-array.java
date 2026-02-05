class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            if(nums[i] == 0) nums[i] = -1;
        }
        int len = 0;
        HashMap<Integer,Integer> sumTrackerMap = new HashMap<>();
        int i = 0;
        for (; i < n; i++){
            if(!sumTrackerMap.containsKey(sum)){
                sumTrackerMap.put(sum,i);
            }else{
                len = Math.max(len, i - sumTrackerMap.get(sum));
            }
            sum += nums[i];
        }
        if(sumTrackerMap.containsKey(sum)){
            len = Math.max(len, i - sumTrackerMap.get(sum));
        }
        return len;
    }
}