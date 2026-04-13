class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int firstmax = 1;
        int secondmax = 1;
        for (int i = 0 ; i < n ; i++){
            if(nums[i] >= firstmax){
                secondmax = firstmax;
                firstmax = nums[i];
            }
            else if(nums[i] > secondmax && nums[i] < firstmax){
                secondmax = nums[i];
            }
        }
        return (firstmax - 1) * (secondmax - 1);
    }
}