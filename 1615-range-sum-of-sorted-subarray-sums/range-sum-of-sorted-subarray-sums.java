class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int length = (n * (n + 1) / 2);
        int[] sumArray = new int[length];
        int index = 0;
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum += nums[j];
                sumArray[index++] = sum;
            }
        }
        Arrays.sort(sumArray);
        long actualsum = 0;
        long MOD = 1000000007;
        for(int i = left ; i <= right ; i++){
            actualsum = (actualsum + sumArray[i - 1]) % MOD;
        }
        return (int)actualsum;
    }
}