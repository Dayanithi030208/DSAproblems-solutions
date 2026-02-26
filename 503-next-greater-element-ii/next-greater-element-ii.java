class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack< Integer > stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[ n ];
        for (int i = n - 1 ; i >= 0; i--){
            while ( !stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for (int i = n - 1 ; i >= 0; i--){
            while ( !stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }
}