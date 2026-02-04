class Solution {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length-1;
        int sum = 0;
        int max = 0;
        for (int i = 0;i < k;i++){
            sum += cardScore[i];
        }
        max = sum;
        for (int i = 0;i < k;i++){
            sum -= cardScore[k-1-i];
            sum += cardScore[n-i];
            max = Math.max(sum,max);
        }
        return max;
    }
}