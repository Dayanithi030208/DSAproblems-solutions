class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer , Integer> freq = new HashMap<>();
        int count = 0;
        for(int num : nums){
            freq.put(num , freq.getOrDefault(num , 0) + 1);
        }
        for(int num : freq.keySet()){
            if( k != 0 ){
                int value = num + k;
                if(freq.containsKey(value)) count++;
            }
            else{
                if(freq.get(num) >= 2) count++;
            }
        }
        return count++;
    }
}