class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0 || c == 1) return true;
        long sqrt = (long)Math.sqrt(c);
        if(sqrt * sqrt == c) return true;
        long left = 1;
        long right = sqrt;
        while(left <= right){
            long value = ( left * left ) + ( right * right );
            if ( value == (long) c) return true;
            else if ( value > (long) c) right = right - 1; 
            else left = left + 1;
        }
        return false;
    }
}