class Solution {
    public int candy(int[] ratings) {
        //  Approach 1
        // int n = ratings.length;
        // int[] leftcheck = new int[n];
        // leftcheck[0] = 1;
        // int c = 1;
        // for(int i = 1 ; i < n ; i++){
        //     if(ratings[i] > ratings[i - 1]){
        //         c++;
        //         leftcheck[i] = c;
        //     }
        //     else{
        //         c = 1;
        //         leftcheck[i] = c;
        //     }
        // }
        // c = 1;
        // int chocolates = 0 ;
        // for(int i = n - 2 ; i >= 0 ; i--){
        //     if(ratings[i] > ratings[i + 1]){
        //         c++;
        //         chocolates += Math.max(leftcheck[i] ,c);
        //     }
        //     else{
        //         c = 1;
        //         chocolates += Math.max(leftcheck[i] ,c);
        //     }
        // }
        // chocolates += Math.max(leftcheck[n - 1],1);
        // return chocolates;
        //  Approach 2
        int n = ratings.length ;
        int i = 1;
        int peak = 0;
        int down = 0;
        int chocolates = 1;
        while (i < n){
            if(ratings[i] == ratings[i-1]){
                chocolates += 1;
                i++;
                continue;
            }
            peak = 1 ;
            while ( i < n  && ratings[i] > ratings[i - 1]){
                peak++;
                chocolates += peak;
                i++;
            }
            down = 1 ;
            while ( i < n && ratings[i] < ratings[i - 1]){
                chocolates += down;
                down++;
                i++;
            }
            if(peak < down){
                chocolates += (down - peak);
            }
        }
        return chocolates;
    }
}