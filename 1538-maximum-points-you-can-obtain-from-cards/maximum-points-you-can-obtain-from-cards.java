class Solution {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length;
        if(k > n) return -1;
        int sum = 0;
        int max = 0;
        for (int i = 0;i < k;i++){
            sum += cardScore[i];
        }
        max = sum;
        if(k == n) return max;
        for (int i = 0;i < k;i++){
            sum -= cardScore[k-1-i];
            sum += cardScore[n-i-1];
            max = Math.max(sum,max);
        }
        return max;
    }
}