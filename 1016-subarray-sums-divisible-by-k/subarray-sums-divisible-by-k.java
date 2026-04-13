class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 ,1);
        int prefixsum = 0;
        int n = nums.length;
        int count = 0;
        for (int right = 0 ; right < n; right++){
            prefixsum = ((( prefixsum + nums[right] ) % k + k) % k);
            if(map.containsKey(prefixsum % k)){
                count += map.get(prefixsum % k);
            }
            map.put(prefixsum , map.getOrDefault(prefixsum , 0 ) + 1);
        }
        return count;
    }
}