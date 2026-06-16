class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        HashSet<String> pairs = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
               int value = Math.abs(nums[i] - nums[j]);
               if(value == k){
                int a = Math.min(nums[i] , nums[j]);
                int b = Math.max(nums[i] , nums[j]);
                pairs.add( a + " , " + b );
               }
            }
        }
        return pairs.size();
    }
}