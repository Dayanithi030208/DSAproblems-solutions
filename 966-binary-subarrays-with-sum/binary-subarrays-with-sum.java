class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixsum = 0;
        map.put(0,1);
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            prefixsum += nums[i];
            if(map.containsKey(prefixsum - goal)){
                count += map.get(prefixsum - goal);
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}