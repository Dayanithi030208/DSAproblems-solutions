class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftcheck = new int[n];
        int[] rightcheck = new int[n];
        leftcheck[0] = 1;
        int c = 1;
        for(int i = 1 ; i < n ; i++){
            if(ratings[i] > ratings[i - 1]){
                c++;
                leftcheck[i] = c;
            }
            else{
                c = 1;
                leftcheck[i] = c;
            }
        }
        c = 1;
        for(int i = n - 2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i + 1]){
                c++;
                rightcheck[i] = c;
            }
            else{
                c = 1;
                rightcheck[i] = c;
            }
        }
        int chocolates = 0 ;
        for(int i = 0 ; i < n ; i++){
            chocolates += Math.max(leftcheck[i] , rightcheck[i]);
        }
        return chocolates;
    }
}