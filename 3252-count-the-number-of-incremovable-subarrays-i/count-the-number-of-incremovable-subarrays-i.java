class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isIncRemovable(nums , i , j)) count++;
            }
        }
        return count;
    }
    private boolean isIncRemovable(int[] nums , int start , int end){
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(i >= start && i <= end) continue;
            else if(!list.isEmpty() && list.get(list.size() - 1) >= nums[i]) return false;
            else list.add(nums[i]);
        }
        return true;
    }
}